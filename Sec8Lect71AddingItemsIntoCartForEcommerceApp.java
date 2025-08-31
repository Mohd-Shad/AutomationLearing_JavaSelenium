package Automationsel5;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sec8Lect71AddingItemsIntoCartForEcommerceApp {

	public static void main(String[] args) throws InterruptedException {
		// Important Question asked in Amazon interview
		// Lect-71,72,73,74,75 -> Adding Items into Cart for Ecommerce App
		// Section 9 -> Synchronization usage in Selenium webdriver -> Lec covered -> 77,78,79,80,,81
		

		// Opening new Chrome Driver
		WebDriver driver = new ChromeDriver();
		
		//Below is Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		addItems(driver,itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//explicit wait is applied to target specific element on web page it does not effect any another element
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
 	}

	
	public static void addItems(WebDriver driver,String[] itemsNeeded) {
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;
		for (int i = 0; i < product.size(); i++) {

			// Brocolli - 1 Kg
			String[] name = product.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// name[0] -> Brocolli
			// name[1] -> 1 Kg

			// format it to get actual vegetable name

			// check weather name you extrected is present in array or not.
			// convert array into array list for easy search
			List itemNeededList = Arrays.asList(itemsNeeded);

			// name.contains("Cucumber")
			// itemNeededList.contains(name)
			if (itemNeededList.contains(formattedName)) {

				j++;
				// click on Add to Cart
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// break;
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}

}
