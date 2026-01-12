package section13MiscellaneousTopicsInSeleniumWebDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AutomateBrokenLinks {

	@Test(enabled = false)
	public void getSingleBrokenURL() throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// First link
		String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getDomAttribute("href");
		HttpURLConnection conn = (HttpURLConnection) URI.create(url).toURL().openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		System.out.println("Response for soapui link: " + conn.getResponseCode());

		// Second link
		String url1 = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getDomAttribute("href");
		HttpURLConnection conn1 = (HttpURLConnection) URI.create(url1).toURL().openConnection();
		conn1.setRequestMethod("HEAD");
		conn1.connect();
		System.out.println("Response for brokenlink: " + conn1.getResponseCode());

		driver.quit();
	}

	@SuppressWarnings("deprecation")
	@Test(enabled=false)
	public void getSinglebrokenURL1() throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// -------------------- First link: SoapUI --------------------
		String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getDomAttribute("href");

		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();

		int respCode = conn.getResponseCode();
		System.out.println("Response for SoapUI link: " + respCode);

		// -------------------- Second link: Broken Link --------------------
		String url1 = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getDomAttribute("href");

		HttpURLConnection conn1 = (HttpURLConnection) new URL(url1).openConnection();
		conn1.setRequestMethod("HEAD");
		conn1.connect();

		int respCode1 = conn1.getResponseCode();
		System.out.println("Response for Broken Link: " + respCode1);
		

		// -------------------- Third link: Broken Link --------------------
		String url2 = driver.findElement(By.cssSelector("a[href*='udemy']")).getDomAttribute("href");

		HttpURLConnection conn2 = (HttpURLConnection) new URL(url2).openConnection();
		conn2.setRequestMethod("HEAD");
		conn2.connect();

		int respCode2 = conn2.getResponseCode();
		System.out.println("Response for Broken Link: " + respCode2);
		

		// driver.findElement(By.xpath("//a[contains(text(),'SoapUI')]")).getAttribute("href");
		System.out.println(driver.findElement(By.xpath("//a[text()='SoapUI']")).getAttribute("href"));
		// Close the browser
		driver.quit();
	}

	
	@SuppressWarnings("deprecation")
	@Test(enabled=false)
	public void iterateOverAllLinksToGetBrokenLink() throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul/li"));
		// driver.findElements(By.cssSelector("div[id='gf-BIG'] table tbody tr td ul
		// li"));

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for (WebElement link : links) {

			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();

			System.out.println(respCode);
			if (respCode > 400) {
				System.out.println("The link with Test " + link.getText() + " is broken with code " + respCode);
				Assert.assertTrue(false);
			}

		}
		driver.quit();

	}
	
	@Test
	public void iterateOverAllLinksToGetBrokenLinkSoftAssert() throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul/li"));
		// driver.findElements(By.cssSelector("div[id='gf-BIG'] table tbody tr td ul
		// li"));

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		
		
		for (WebElement link : links) {

			String url = link.getAttribute("href");
			@SuppressWarnings("deprecation")
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			
			a.assertTrue(respCode < 400, "The link with Test " + link.getText() + " is broken with code " + respCode);
			
		}
		a.assertAll();
		driver.quit();
	}

	/*
	 * Steps: 1. Get all URLs tied up to the links using Selenium. 2. Use Java
	 * methods to get the status code of each URL. 3. If status code > 400, then URL
	 * is broken (not working).
	 */

	// Reference Links
	// http://www.rahulshettyacademy.com/practice-project
	// https://rahulshettyacademy.com/AutomationPractice/

	/*
	 * Alternative ways of getting href attribute:
	 * 
	 * String url1 =
	 * driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
	 * String url2 = driver.findElement(By.linkText("SoapUI")).getAttribute("href");
	 * 
	 * System.out.println(url1); System.out.println(url2);
	 */
}
