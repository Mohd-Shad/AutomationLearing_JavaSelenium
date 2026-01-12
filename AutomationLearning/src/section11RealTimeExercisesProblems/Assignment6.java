package section11RealTimeExercisesProblems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Assignment6 {

	@Test
	public void checkBox() {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1 Select Any CheckBox
		driver.findElement(By.cssSelector("input#checkBoxOption2")).click();

		// 2 Grab the label of the selected checkbox and put into variable
		String selectedOption = driver.findElement(By.cssSelector("label[for='benz']")).getText();

		// 3 Select An Option in dropdown. Here option to select should come from step 2
		// Handling Static Drop Down by creating object of select class

		WebElement staticDropdown = driver.findElement(By.cssSelector("select[id*=dropdown]"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByContainsVisibleText(selectedOption);

		// 4 Enter the step 2 grabbed label text in Editbox
		driver.findElement(By.id("name")).sendKeys(selectedOption);

		// 5 Click Alert button and then verify if text grabbed from step 2 is present
		// in the pop up
		driver.findElement(By.id("alertbtn")).click();
		String text = driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		System.out.println(text);

		if (text.equals(selectedOption)) {
			System.out.println("Grabbed text is present in alert box");
		}
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		
		driver.quit();

	}

}
