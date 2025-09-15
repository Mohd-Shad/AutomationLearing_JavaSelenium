package section13MiscellaneousTopicsInSeleniumWebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Lec108HowToTakeScreenshotsInSelenium {

	public static void main(String[] args) throws IOException{
		//Lect->108 How to take Screenshots in Selenium

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://google.com");
		
		//Code to take screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\usman\\ScreenShot\\screenshot.png"));
	}

}
