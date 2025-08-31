package Automationsel5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//TestNG is one of the testing Frame work

public class Sec7Lec60Handlingcheckboxandgettingthesizeofthemwithselenium {

	public static void main(String[] args) {
		// Lect-60 Handling Checkbox and getting the size of them with selenium
		//Lect-61 Importance of Assertions in Automation testing and how to use them
		
		
		//Below line code indicate you are setting the Chrome driver path
		//System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
				
		//Initializing the driver object of Chromedriver class
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		//Count the number of checkboxes
		 System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		 
		
	}

}
