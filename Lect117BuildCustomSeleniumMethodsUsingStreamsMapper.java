package section14SeleniumJavaStreams;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lect117BuildCustomSeleniumMethodsUsingStreamsMapper {

	public static void main(String[] args) {
		// Lec117 -> Build Custom Selenium Methods Using Streams Mapper
		// Select the Particular vegetable from the table and print it's price
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

		// scan the name column with getText ->Beans ->print the price of the Beans
		List<String> price = elementsList.stream().filter(s -> s.getText().contains("Beans"))
				.map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		
		price.forEach(a->System.out.println(a));

	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
