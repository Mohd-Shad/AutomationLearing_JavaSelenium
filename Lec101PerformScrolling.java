package section12PracticalProblemsAndMethodsToHandleThemWithSelenium;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Lec101PerformScrolling {

	public static void main(String[] args) throws InterruptedException {
		//Lec-101 -> Learning how to perform scrolling with in table and window level using JavaScriptExecutor
		//Lec-102 -> Learning how to handle grids in webpage
		//Lec-103 -> Learning Parsing String and comparing with Generated Sum value
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Using Java Script to perform Window Scroll
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Browser Window Level Scrolling
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		//Table Level Scrolling
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		
		int sum = 0;
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i = 0; i<values.size(); i++) {
			
			sum += Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		
		
		//driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim();
		
		int num = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].split(" ")[1]);
		System.out.println(num);
		
		Assert.assertEquals(sum, num);
	}

}
