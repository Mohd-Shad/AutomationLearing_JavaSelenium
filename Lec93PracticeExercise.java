package section11RealTimeExercisee2eProgramming;

import java.util.Set;

import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lec93PracticeExercise {

	public static void main(String[] args) {
		//Lec-93 -> Calculate link count in the Page
		//Lec-94 -> Limiting webdriver scope
		//Lec-95 -> How to open links in Separate Tabs - Optimized solution
		//Lec-96 -> Getting the titled of child tabs with optimized while loop
		
		
		//1. Give me the count of links on the page. //a
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Getting the count of all the links present on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Get the count of the link present only in the footer of the page
		//Create a mini driver which has access to that footer par only
		
		WebElement miniDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(miniDriver.findElements(By.tagName("a")).size());
		
		//3
		WebElement columndriver = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//4- click on each link in the column and check if the pages are opening
		
		for(int i = 1; i<columndriver.findElements(By.tagName("a")).size(); i++) {
			
			//Opening all the links in separate Window in one go
			
		    String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		    columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			//columndriver.findElements(By.tagName("a")).get(i).sendKeys(Keys.ENTER);
		    //columndriver.findElements(By.tagName("a")).get(i).click();
		    
			//driver.navigate().back();
		}// opens all the tabs
		
		
		
		    Set<String> abc = driver.getWindowHandles();
		    Iterator<String> it = abc.iterator();
		    
		    while(it.hasNext()){
		    	driver.switchTo().window(it.next());
		    	System.out.println(driver.getTitle());
		    }
	}
		    
}
