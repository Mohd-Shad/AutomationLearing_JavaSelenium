package section13MiscellaneousTopicsInSeleniumWebDriver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HowToTakeScreenShots {

	@Test
	public void screenShot() throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");

		// Below is the Code to take screenshot
		// Catsting driver objet to take screenshot method object
		// Takes the screen shots ////Coping the screenshot to local system so that we
		// can see that
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\mohdusmani\\ScreenShot\\sc2.png"));

	}

	// https://commons.apache.org/io/download_io.cgi

}
