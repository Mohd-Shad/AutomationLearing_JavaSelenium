package section12PracticalProblemsAndMethodsToHandleThemWithSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sec12Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// Section-12 Assignment-8

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		/*
		 * driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("uni"
		 * ); Thread.sleep(3000);
		 * driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		 * driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		 * 
		 * System.out.println(driver.findElement(By.id("autocomplete")).getAttribute(
		 * "value"));
		 */

		driver.manage().window().maximize();
		driver.findElement(By.id("autocomplete")).sendKeys("united");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ui-menu-item']")));

		// WebElement suggestion_id=
		// driver.findElement(By.xpath("//ul[@id='ui-id-1']"));
		List<WebElement> suggestion_list = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		System.out.println("size of list is " + suggestion_list.size());
		String expected = "United States (USA)";
		for (WebElement suggestion : suggestion_list) {
			if (suggestion.getText().equalsIgnoreCase("United States (USA)")) {
				suggestion.click();
				break;
			}
		}
		Thread.sleep(5000);
		String user_val = driver.findElement(By.id("autocomplete")).getAttribute("value");
		if (user_val.equals(expected))
			System.out.println("Test has passsed with selection as " + user_val);

		driver.close();

	}

}
