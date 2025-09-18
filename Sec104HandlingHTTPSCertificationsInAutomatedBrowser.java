package section13MiscellaneousTopicsInSeleniumWebDriver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Sec104HandlingHTTPSCertificationsInAutomatedBrowser {

	public static void main(String[] args) {
		//Lec-104 -> Handling HTTPS certifications in Automated browser
		//Lec-105 -> Explore Chrome options to set proxies,plugins & paths on Chrome browser
		
		
		//Creating Object of ChromeOptions Class
		ChromeOptions options = new ChromeOptions();
		
		// Add the WebDriver proxy capability.
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:444");
		options.setCapability("proxy", proxy);
		
		// Set download directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		//Block dialog windows
		options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		
		//Accepting ssl Certificate
		options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com");
		System.out.println(driver.getTitle());
		

	}

}
