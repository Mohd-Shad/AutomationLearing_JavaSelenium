package Automationsel5;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Section6 {

	public static void main(String[] args) throws InterruptedException {
		// Learning Advanced Locators
		String name = "rahul";
		
		//System.setProperty("webdriver.chrome.driver", null)
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		System.out.println(driver.findElement(By.cssSelector("div h2")).getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class=\"login-container\"] h2")).getText(),"Hello "+name +",");
		
		//driver.findElement(By.className("logout-btn")).click();
		
		//locating based on Text of any element
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		//driver.close();
			
	}
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = driver.findElement(By.cssSelector("form p")).getText();
		Thread.sleep(1000);
		//Spliting the string
		
		String[] passwordArray = passwordText.split("'");
		//0th index - Please use temporary password
		//1th index - rahulshettyacademy' to Login.
		
		//String[] passwordArray2 = passwordArray[1].split("'");
		//passwordArray2[0];
		
		 String password = passwordArray[1].split("'")[0];
		
		//0th index - rahulshettyacademy
		//1th index - to Login.
		 
		 return password;
		
		
	}

	
}
