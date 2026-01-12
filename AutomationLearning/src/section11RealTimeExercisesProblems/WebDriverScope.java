package section11RealTimeExercisesProblems;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebDriverScope {

	@Test(enabled = false)
	public void printTheLinksCountInThePage() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Get the count of links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Get the count of all the links present on footer section
		// Limiting WebDriver Scope
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		// Get the count of all the links present in first column in footer section

		// css -> table td:nth-child(1) == table[class='gf-t'] td:nth-child(1)
		// xpath -> //table/tbody/tr/td[1]

		WebElement columndriver = footer.findElement(By.cssSelector("table[class='gf-t'] td:nth-child(1)"));
		List<WebElement> links = columndriver.findElements(By.tagName("a"));
		System.out.println(links.size());

	}

	@Test(enabled=false)
	public void openLinksInSeperateTabs() {

		// click on each link in the column and check if the pages are opening in
		// separate tab

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement footer = driver.findElement(By.id("gf-BIG"));
		WebElement columndriver = footer.findElement(By.cssSelector("table[class='gf-t'] td:nth-child(1)"));
		List<WebElement> links = columndriver.findElements(By.tagName("a"));

		for (int i = 1; i < links.size(); i++) {
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			links.get(i).sendKeys(clickonlinkTab);
		}
	}

	
	@Test
	public void getTitleOfAllTheTabsOpen() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement footer = driver.findElement(By.id("gf-BIG"));
		WebElement columndriver = footer.findElement(By.cssSelector("table[class='gf-t'] td:nth-child(1)"));
		List<WebElement> links = columndriver.findElements(By.tagName("a"));

		for (int i = 1; i < links.size(); i++) {

			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			links.get(i).sendKeys(clickonlinkTab);
			Thread.sleep(3000);
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.quit();
	}

	// it.hasNext() -> checks weather next window is present or not[true/false]
	// it.next() -> move to next window
}
