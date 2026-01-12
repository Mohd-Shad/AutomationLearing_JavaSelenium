package serentica;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class TestNG {

    @Ignore
    @Test
    public void setup(){
        System.out.println("I am inside setup");
    }


    @Test(enabled = false)
    public void testSteps(){
        System.out.println("I am inside testSteps");
    }

    @Test(priority = 1)
    public void tearDown(){
        System.out.println("I am inside tearDown");
    }

    @Test
    public void dropDown(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        System.out.println(driver.getTitle());

        driver.manage().window().maximize();

        // Learned Handling Static Drop Down
        // dropdown with select tag will always -> Static dropdown

        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);

        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }

    @Test
    public void hover(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        Actions a = new Actions(driver);

        //How to perform hover on any element
        a.moveToElement(driver.findElement(By.cssSelector("#mousehover"))).build().perform();
        //How to right click on any element
        a.moveToElement((driver.findElement(By.cssSelector(".jumbotron.text-center.header_style")))).contextClick().build().perform();
        //How to type CAPITAL letter and double click on element
        a.moveToElement(driver.findElement(By.cssSelector("#autocomplete"))).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
    }

    @Test
    public void screenshot() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");

        // Catsting driver objet to take screenshot method object
        //Takes the screen shots
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Copping the screenshot to local system so that we can see that
        FileUtils.copyFile(src, new File("C:\\Users\\mohdusmani\\ScreenShot\\sc1.png"));
    }
}
