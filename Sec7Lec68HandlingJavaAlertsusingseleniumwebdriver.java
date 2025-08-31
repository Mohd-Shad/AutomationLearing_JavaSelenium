package Automationsel5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec7Lec68HandlingJavaAlertsusingseleniumwebdriver {

	public static void main(String[] args) throws InterruptedException {
		// Lec-68 Handling Java Alerts using Selenium Webdriver
		String text = "Rahul";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input#confirmbtn")).click();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
	}

}
