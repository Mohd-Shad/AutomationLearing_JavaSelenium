package Automationsel5;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Sec9Assignment3 {

	public static void main(String[] args) {
		// Sec-9 -> Assignment 3 -> Synchronization with Explicit wait
		
		WebDriver driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String userName = driver.findElement(By.xpath("//div[@class='form-group']//b[1]")).getText();
		String password = driver.findElement(By.xpath("//div[@class='form-group']//b[2]")).getText();
		
		System.out.println(userName + " " + password);
		
		//driver.findElement(By.cssSelector("input#username")).sendKeys(userName);
		//driver.findElement(By.cssSelector(".username")).sendKeys(userName);
		//driver.findElement(By.cssSelector("input[id='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys(password);
		
		//driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
		driver.findElement(By.xpath("//label[@class='customradio'][2]")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.id("myModal")));
		
		//Static dropdown
		WebElement options = driver.findElement(By.xpath("//div[@class='form-group']//select"));
		Select dropDown = new Select(options);
		dropDown.selectByValue("consult");
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
		driver.findElement(By.cssSelector("input#terms")).click();
		driver.findElement((By.id("signInBtn"))).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		//List<WebElement> mobile  = driver.findElements(By.cssSelector(".btn-info"));
		List<WebElement> mobile  = driver.findElements(By.cssSelector("div [class='card-footer'] button"));
		for(int i = 0 ; i < mobile.size(); i++) {
			mobile.get(i).click();
		}
		driver.findElement(By.partialLinkText("Checkout")).click();

	}

}
