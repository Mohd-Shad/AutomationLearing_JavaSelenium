package automationSel6;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Sec10Lec86ActionsDemo {

	public static void main(String[] args) {
		// Lect-> 86,87
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.com/");
		
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("a[data-nav-role='signin']"));
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		//Moves to Specific element
		a.moveToElement(move).contextClick().build().perform();
	}

}
