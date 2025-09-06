package automationSel6;

import java.util.Set;

import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec10Assignment4 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		//driver.findElement(By.cssSelector("a[href*='windows']")).click();
		
		//Steps to handle multiple window
		Set<String> windows = driver.getWindowHandles(); //[parentId, childId]
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		//System.out.println(driver.findElement(By.xpath("//div/h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		//System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());

	}

}
