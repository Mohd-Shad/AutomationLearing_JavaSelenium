package section13MiscellaneousTopicsInSeleniumWebDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lec109StrategyToAutomateTheBrokenLinksWithSelenium {

	public static void main(String[] args) throws MalformedURLException, IOException {
		//Lec-109 -> Strategy to Automate The Broken Links With Selenium
		//Lec-110 -> Iterate over all links in the page to validate broken links mechanism
		
		WebDriver driver = new ChromeDriver();
		
		//broken URL
		//Step 1 - Is to get all urls tied up to the links using Selenium
		// Java methods will call URL's and gets you the status code
		//if status code >400 then that url is not working-> link which tied to url is broken
		//a[href*="soapui"]
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 
		 List<WebElement> links  = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		 
		 for(WebElement link : links) {
			 String url = link.getAttribute("href");
			 HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			 conn.setRequestMethod("HEAD");
			 conn.connect();
			 int respCode = conn.getResponseCode();
			 //System.out.println(respCode);
			 if(respCode>400) {
				 System.out.println("The link with Text"+link.getText()+" is broken with code" +respCode);
				 Assert.assertTrue(false);
			 }
			 
		 }
		 
		  
		 /*
		 //String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		 String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		 System.out.println(url);
		 HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		 conn.setRequestMethod("HEAD");
		 conn.connect();
		 int respCode = conn.getResponseCode();
		 System.out.println(respCode);
		 */
	}

}
