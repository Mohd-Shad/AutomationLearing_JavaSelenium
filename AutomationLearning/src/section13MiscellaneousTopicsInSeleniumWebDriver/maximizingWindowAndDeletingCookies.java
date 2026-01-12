package section13MiscellaneousTopicsInSeleniumWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class maximizingWindowAndDeletingCookies {

	@Test
	public void class1() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("cookie name");
		
		//driver.manage().addCookie("cookiename"); -> Mostly Not used on real world
		
		
		driver.get("https://google.com");
		
	}
}
