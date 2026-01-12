package curahealthcareforpractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;



public class Example1 {
    @Test
    public void login() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        // Click Make Appointment
        driver.findElement(By.id("btn-make-appointment")).click();

        // Read default credentials
        String username = driver.findElement(By.cssSelector("input[placeholder='Username']")).getDomAttribute("value");
        String password = driver.findElement(By.cssSelector("input[placeholder='Password']")).getDomAttribute("value");

        // Login
        driver.findElement(By.id("txt-username")).sendKeys(username);
        driver.findElement(By.id("txt-password")).sendKeys(password);
        driver.findElement(By.id("btn-login")).click();

        // WAIT FOR DROPDOWN TO APPEAR
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("combo_facility")));

        /*WebElement staticdropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("combo_facility"))
        );*/


        // dropdown with select tag will always -> Static dropdown
        // Select from dropdown
        WebElement staticdropdown = driver.findElement(By.id("combo_facility"));
        Select dropdown = new Select(staticdropdown);
        dropdown.selectByIndex(1);

        // Check the checkbox
        driver.findElement(By.xpath("//label[@class='checkbox-inline']")).click();

        // Select the second radio button ("Medicaid")
        driver.findElement(By.xpath("(//label[@class='radio-inline'])[2]")).click();


        // Click datepicker
        /*WebElement dateBox = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("txt_visit_date"))
        );
        dateBox.click();*/
        //driver.findElement(By.xpath("//div[@data-provide='datepicker']")).click();

        driver.findElement(By.cssSelector("#txt_visit_date")).click();
        driver.findElement(By.cssSelector("input#txt_visit_date")).sendKeys("30/12/2025");
        driver.findElement(By.xpath("//textarea[@id='txt_comment']")).sendKeys("I am trying to learn Automation");
        //driver.findElement(By.cssSelector(".btn-default")).click();
        driver.findElement(By.cssSelector("button.btn-default")).click();

    }

    @Test
    public void login1() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        // Click Make Appointment
        driver.findElement(By.id("btn-make-appointment")).click();

        // Read default credentials
        String username = driver.findElement(By.cssSelector("input[placeholder='Username']")).getDomAttribute("value");
        String password = driver.findElement(By.cssSelector("input[placeholder='Password']")).getDomAttribute("value");

        // Login
        driver.findElement(By.id("txt-username")).sendKeys(username);
        driver.findElement(By.id("txt-password")).sendKeys(password);
        driver.findElement(By.id("btn-login")).click();

        // dropdown with select tag will always -> Static dropdown
        // WAIT FOR DROPDOWN TO APPEAR
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement staticdropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("combo_facility"))
        );


        // Select from dropdown
        Select dropdown = new Select(staticdropdown);
        dropdown.selectByIndex(1);


        // Check the checkbox
        driver.findElement(By.xpath("//label[@class='checkbox-inline']")).click();

        // Select the second radio button ("Medicaid")
        driver.findElement(By.xpath("(//label[@class='radio-inline'])[2]")).click();


        // Click datepicker
        WebElement date = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("txt_visit_date"))
        );
        date.click();
        date.sendKeys("30/12/2025");
    }
}
