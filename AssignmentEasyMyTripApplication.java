package Automationsel5;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssignmentEasyMyTripApplication {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("http://google.com");
		driver.navigate().to("https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChsSEwjh2IGK46WPAxXcpGYCHfvZJwcYACICCAEQABoCc20&co=1&ase=2&gclid=CjwKCAjwk7DFBhBAEiwAeYbJsUGWFywBAw5pvYyVDj6AqzCSFQzrhY7YxDH_2dt1ZaPcHWMmUFYWvBoC-IQQAvD_BwE&ohost=www.google.com&cid=CAESeeD2MNT7cbbEQDebsGq9XdqeqgBPrLSoZIx1GA_G9CwTb14irZR6mEoPkh9moBhkPqJvGA40JYLvrb7m1G9XhSmZuz7zq4vGDsLbc6dZ_ax4_S6JA0OuZsvX6JW8I9sE6_m4MKMhzovVZB_DVc56i1eB01KtHd0xfAU&category=acrcp_v1_40&sig=AOD64_0aPsH3Ej9hzeVa-zoT0SrYIPdpWg&q&nis=4&adurl&ved=2ahUKEwiUkvyJ46WPAxX_UGcHHVMaIbgQ0Qx6BAgKEAE");
		driver.findElement(By.id("FromSector_show")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span#spn3")).click();
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("(//span[@id='spn11'])[2]")).click();
		
		//Below line of code is -> Xpath Parent-Child relationship locator to identify the objects uniquely
		driver.findElement(By.xpath("//div[@id='toautoFill_in'] //span[@id='spn11']")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("active-date")).click();
		System.out.println(driver.findElement(By.id("rtag")).getDomAttribute("Style"));
		driver.findElement(By.id("rtrip")).click();
		System.out.println(driver.findElement(By.id("rtag")).getDomAttribute("Style"));
		
		if(driver.findElement(By.id("rtag")).getDomAttribute("Style").contains("display: none")) {
			System.out.println("Its enabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}

		driver.findElement(By.id("oway")).click();
		
		
		driver.findElement(By.cssSelector("#myFunction4")).click();
		Thread.sleep(2000);
		String ans =  driver.findElement(By.id("spnDrpNo")).getText() + " " + driver.findElement(By.id("spnTraveller")).getText();
		System.out.println(ans);
		
		int i = 1;
		while(i<5) {
			driver.findElement(By.id("add")).click();
			i++;
		}
		
		driver.findElement(By.id("traveLer")).click();
		Assert.assertEquals(driver.findElement(By.id("spnDrpNo")).getText() + " " + driver.findElement(By.id("spnTraveller")).getText(), "5 Travellers");
		
		String ans1 =  driver.findElement(By.id("spnDrpNo")).getText() + " " + driver.findElement(By.id("spnTraveller")).getText();
		System.out.println(ans1);
		
		driver.findElement(By.cssSelector("#chkArmy")).click();
		driver.findElement(By.cssSelector("input.srchBtnSe")).click();
		driver.navigate().back();
		
		
		//////////////////////////////////
		
		driver.findElement(By.id("FromSector_show")).click();
		
		driver.findElement(By.id("a_FromSector_show")).sendKeys("dub");
		Thread.sleep(3000);
		
		//Below line of code is -> Css Parent-Child relationship locator to identify the objects uniquely
		List<WebElement> options = driver.findElements(By.cssSelector("ul[class='ausuggest'] span"));
		for(WebElement option : options) {
			if(option.getText().equalsIgnoreCase("Dubai(DXB)")) {
				option.click();
				break;
			}
		}
		
		
		
	}

}
