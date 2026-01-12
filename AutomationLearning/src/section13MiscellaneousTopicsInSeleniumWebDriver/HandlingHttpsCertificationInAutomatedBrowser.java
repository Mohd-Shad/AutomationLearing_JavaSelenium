package section13MiscellaneousTopicsInSeleniumWebDriver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class HandlingHttpsCertificationInAutomatedBrowser {

	@Test
	public void handlingHttpsCertification() {

		// Handling HTTPS certifications in Automated browser using ChromeOptions class

		// Creating Object of ChromeOptions Class
		ChromeOptions options1 = new ChromeOptions();
		// Accepting ssl Certificate
		options1.setAcceptInsecureCerts(true);

		FirefoxOptions options2 = new FirefoxOptions();
		options2.setAcceptInsecureCerts(true);

		EdgeOptions options3 = new EdgeOptions();
		options3.setAcceptInsecureCerts(true);

		WebDriver driver = new ChromeDriver(options1);
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

	/*
	 * The ChromeOptions class in Selenium WebDriver provides a mechanism to
	 * customize and configure the behavior of the Chrome browser during automated
	 * testing. It allows users to modify various settings and capabilities specific
	 * to ChromeDriver sessions.
	 */

	@Test
	public void chromeOptionsToSet() {

		// https://sites.google.com/chromium.org/driver/capabilities -> Link for
		// documentation
		// Explore Chrome options to set proxies, plugins&paths on Chrome browser

		// Creating Object of ChromeOptions Class
		ChromeOptions options = new ChromeOptions();

		// Add the WebDriver proxy capability.
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:444");
		options.setCapability("proxy", proxy);

		// Set download directory
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);

		// Block dialog windows
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		// Accepting ssl Certificate
		options.setAcceptInsecureCerts(true);
		

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com");
		System.out.println(driver.getTitle());
	}
}
