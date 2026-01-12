package section12PracticalProblemAndMethodsToHandelThemWithSelenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Section12 {
	
	
	@Test(enabled=false)
	public void scrolling() throws InterruptedException {
		//How to Perform Scrolling with in table and Window level using JavaScriptExecutor
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		//casting driver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//scrolling at window level -> Scroll on Page level
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(3000);
		
		//scrolling at table level -> Scroll on Component level
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");	
		
	}
	
	@Test
	public void handelTableGridsInWebPage() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	
		// css -> .tableFixHead td:nth-child(4) == div.tableFixHead td:nth-child(4) == div[class='tableFixHead'] td:nth-child(4) == div[class='tableFixHead'] table tbody tr td:nth-child(4)
		// xpath ->  //div[@class='tableFixHead']/table/tbody/tr/td[4] 
		// xpath -> (//tbody)[2]//tr/td[4]
		
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int sum = 0;
		
		for(WebElement value : values) {
			
			sum += Integer.parseInt(value.getText());
		}
		
		System.out.println(sum);
		
		String str = driver.findElement(By.cssSelector("div.totalAmount")).getText();
		int num = Integer.parseInt(str.split(":")[1].trim());
		Assert.assertEquals(sum, num);
		
		
		driver.quit();
	}

}
