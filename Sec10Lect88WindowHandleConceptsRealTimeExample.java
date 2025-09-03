package automationSel6;

import java.util.Set;

import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec10Lect88WindowHandleConceptsRealTimeExample {

	public static void main(String[] args) {
		
		//Lect- 88, 89
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		//Steps to handle multiple window
	    Set<String> windows	= driver.getWindowHandles(); //[parentId, childId]
	    Iterator<String>it = windows.iterator();
	    String parentId = it.next();
	    String childId = it.next();
	    driver.switchTo().window(childId);
	    
	    System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
	    String username1 = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
	    System.out.println(username1);
	    
	    String username2 = driver.findElement(By.cssSelector("p[class='im-para red'] a")).getText();
	    System.out.println(username2);
	    driver.switchTo().window(parentId);
	    driver.findElement(By.cssSelector("input#username")).sendKeys(username2);
	    
	    

	}

}
