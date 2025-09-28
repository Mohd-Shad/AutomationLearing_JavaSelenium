package section14SeleniumJavaStreams;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Lect116PerformWebTableSortingUsingSeleniumJavaStreams {

	public static void main(String[] args) {
		// Lect116->PerformWebTableSortingUsingSeleniumJavaStreams
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Step1 -> click on column
		// Step2 -> capture all webelements into new(original) list
		// Step3 -> sort on the original list of step 3 -> sorted list
		// Step4 -> compare original list vs sorted list

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));

	}

}
