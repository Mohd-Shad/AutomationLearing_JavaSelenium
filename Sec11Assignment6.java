package section11RealTimeExercisee2eProgramming;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sec11Assignment6 {

	public static void main(String[] args) {
		
		//Invoking the chrome driver
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1.Select Any CheckBox
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		
		//2.Grab the label of selected text 
		String selectedOption = driver.findElement(By.cssSelector("label[for='benz']")).getText();
		
		//3.Select an option in Static dropDown. Here option to select should come from step2
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(selectedOption);
		
		//4.Enter the step 2 grabbed label text in editbox 
		driver.findElement(By.cssSelector("input[name='enter-name']")).sendKeys(selectedOption);
		driver.findElement(By.id("alertbtn")).click();
		
		//5. Click Alert and then verify if text grabbed from step 2 is present in the pop up
		String text = driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		System.out.println(text);
		
		if(text.equals(selectedOption)) {
			System.out.println("Grabbed text is present in alert box");
		}
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		

	}

}
