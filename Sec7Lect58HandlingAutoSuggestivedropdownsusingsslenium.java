package Automationsel5;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec7Lect58HandlingAutoSuggestivedropdownsusingsslenium {

	public static void main(String[] args) throws InterruptedException {
		
		//Lect-58 Handling AutoSuggestive dropdowns using selenium
		
		
		//Below line code indicate you are setting the Chrome driver path
		//System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
		
		//Initializing the driver object of Chromedriver class
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		
		
		
		
	}

}
