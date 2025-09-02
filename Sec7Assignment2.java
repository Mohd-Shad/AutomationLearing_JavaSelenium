package Automationsel5;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;

public class Sec7Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// Assignment->2
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Mohd Shad Usmani");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("usmanimohd56@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Fakepwd@12345");
		driver.findElement(By.id("exampleCheck1")).click();
		
		WebElement staticDropdown  = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropDown = new Select(staticDropdown);
		dropDown.selectByIndex(1);
		Thread.sleep(2000);
		dropDown.selectByVisibleText("Male");
		
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("15-04-2000");
		
		//driver.findElement(By.cssSelector(".btn-success")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//System.out.println(driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());
		System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());

	}

}
