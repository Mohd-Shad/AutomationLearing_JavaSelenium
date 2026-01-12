package section12PracticalProblemAndMethodsToHandelThemWithSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment7 {
	
	
	@Test
	public void WebTableAssignment() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Print No of Row Present in first Table of the above web page
		
		// xpath -> (//table[@id='product'])[1]/tbody/tr  == (//table[@id='product']/tbody[1])[1]/tr 
		// css -> table[id='product'] tbody:nth-child(1) tr
		
		List<WebElement> row = driver.findElements(By.cssSelector("table[id='product'] tbody:nth-child(1) tr"));
		System.out.println("Number of row = " + row.size());
		
		//Print No of Column Present in first Table of the above web page
		//table[@id='product']/tbody/tr/th == //table[@id='product']//tbody//tr[1]//th == (//table[@id='product']//tbody//tr)[1]/th
		
		List<WebElement> column = driver.findElements(By.xpath("(//table[@id='product']//tbody//tr)[1]/th"));
		System.out.println("Number of Columns = " + column.size());
		
		//Print the data of Third Row
		// (//table[@id='product']/tbody)[1]/tr[3]/td == (//table[@id='product']//tbody//tr)[3]/td
		List<WebElement> data = driver.findElements(By.xpath("(//table[@id='product']//tbody//tr)[3]/td"));
		for(int i = 0; i<data.size(); i++) {
			System.out.println(data.get(i).getText());
		}
		driver.quit();
	}
}
