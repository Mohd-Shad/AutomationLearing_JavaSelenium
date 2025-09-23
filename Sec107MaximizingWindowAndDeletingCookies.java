package section13MiscellaneousTopicsInSeleniumWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec107MaximizingWindowAndDeletingCookies {

	public static void main(String[] args) {
		//Lec-107 Maximizing window and deleting cookies
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//deleting cookies
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("abcdef");
		
		//click on any link
			//login page - verify login url
		
		driver.get("http://google.com");
	}

}
