package automateSortingPaginationFilteringInWebTables;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class WebTableRealWorldAutomationPrograms {

	// Below Test Case Is comparing weather the searched product we are getting in
	// table or not

	@Test(enabled = false)
	public void searchProduct() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		String searchedProduct = "BanANA";

		driver.findElement(By.cssSelector("#search-field")).sendKeys(searchedProduct);
		List<WebElement> products = driver.findElements(By.cssSelector("tbody tr td:first-child"));
		// List<WebElement> products =
		// driver.findElements(By.xpath("//tbody/tr/td[1]"));

		for (int i = 0; i < products.size(); i++) {
			String productName = products.get(i).getText();
			if (productName.equalsIgnoreCase(productName) == searchedProduct.equalsIgnoreCase(searchedProduct)) {
				Assert.assertTrue(true);
			}
			System.out.println(productName);
		}

		/*
		 * boolean allMatch = products.stream() .allMatch(product ->
		 * product.getText().contains("Potato"));
		 * 
		 * Assert.assertTrue(allMatch, "Not all products contain 'Potato'");
		 */

		/*
		 * for(WebElement product : products) { String productText = product.getText();
		 * Assert.assertTrue(productText.contains("Potato"),
		 * "Expected 'Potato' but found: " + productText); }
		 */

		// Learned Performing Web Table Sorting using Selenium Java Streams
	}

	@Ignore
	public void sortingTableElement() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Step1 Click on column
		// Step2 Capture all the elements in WebElement
		// Step3 Capture text of all elements into new list(original list)
		// Step4 Apply sort in the list got from Step3 -> (sorted list)
		// Step5 Compare original list vs sorted list

		// driver.findElement(By.cssSelector(".sort-icon.sort-descending")).click();
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elementsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
	}

	@Test(enabled = false)
	public void getPriceOfProduct() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));

		// scan the name column with getText -> Beans -> print the price of the Rice
		List<String> price = elementsList.stream().filter(s -> s.getText().contains("Beans"))
				.map(s -> getPriceVeggie(s)).collect(Collectors.toList());

		price.forEach(a -> System.out.println(a));
	}

	/*
	 * private static String getPriceVeggie(WebElement s) {
	 * 
	 * // TODO Auto-generated method stub //tr/td[1]/following-sibling::td[1] String
	 * priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
	 * return priceValue; }
	 */

	@Ignore
	public void paginationSorting() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> price;
		
		// scan the name column with getText -> Beans -> print the price of the Rice
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			price.forEach(a -> System.out.println(a));

			if (price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);

	}

	private static String getPriceVeggie(WebElement s) {

		// TODO Auto-generated method stub //tr/td[1]/following-sibling::td[1]
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
	
	@Test
	public void filterProduct() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.id("search-field")).sendKeys("Apple");
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filterredList = veggies.stream().filter(s->s.getText().contains("Apple")).collect(Collectors.toList());
		
		for(WebElement w : filterredList) {
			if(w.getText().equals("Apple")) {
			    Assert.assertTrue(true);
			}
		}
		//Assert.assertEquals(veggies.size(), filterredList.size());
		driver.quit();
	}

}


/*
 * The map() operation in Java Streams is used when a transformation needs to be applied to each element of a stream,
 *  resulting in a new stream containing the transformed elements.
 */
 
