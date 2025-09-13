package section12PracticalProblemsAndMethodsToHandleThemWithSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Sec12Assignment7 {

	public static void main(String[] args) {
		// Sec-12 Assignment 7: Web Tables Assignment
		// Print Number of row,column and 2nd row data
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> row = driver.findElements(By.xpath("//table[@id='product']//tbody//tr[1]//th"));
		
		System.out.println("Number of row in a table = " + row.size());
		
		List<WebElement> column = driver.findElements(By.xpath("(//table[@id='product']//tbody)[1]//tr"));
		
		System.out.println("Number of column in a table = " + column.size());
		
		List<WebElement> data = driver.findElements(By.xpath("(//table[@id='product']//tbody)[1]//tr[3]//td"));
		
		for(int i = 0; i<data.size(); i++) {
			System.out.println(data.get(i).getText());
		}

	}

}
