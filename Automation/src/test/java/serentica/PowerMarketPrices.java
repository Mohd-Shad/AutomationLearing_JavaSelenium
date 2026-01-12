package serentica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.io.File;
import java.util.Map;

public class PowerMarketPrices {

    @Parameters({"URL"})
    @Test
    public void heading(String url){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(url);
        driver.get(url);
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='header-label'])[1]")));
        System.out.println(driver.findElement(By.xpath("(//div[@class='header-label'])[1]")).getText());*/
        Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='header-label'])[1]")).getText(),"Power Market Prices");
        driver.quit();
    }

    @Parameters({"URL"})
    @Test
    public void subHeading(String url){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        String subHeading =  driver.findElement(By.xpath("(//div[@class='header-sub-label'])[1]")).getText();
        Assert.assertEquals(subHeading,"View upcoming and real-time electricity prices at a glance.");
        driver.quit();
    }

    @Parameters({"URL"})
    @Test
    public void verifyDateTime(String url){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        String date = driver.findElement(By.cssSelector("div[class='date-label'] div:nth-child(1)")).getText();
        String utc = driver.findElement(By.cssSelector("div[class='date-label'] div:nth-child(2)")).getText();
        String actualDate = date+" "+utc;
        System.out.println("Date from UI: " + actualDate);

        ZonedDateTime utcNow = ZonedDateTime.now(ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE | dd MMMM yyyy 'UTC' HH:mm", Locale.ENGLISH);
        String expectedDate = utcNow.format(formatter);
        System.out.println("System UTC Date: " + expectedDate);

        Assert.assertEquals(actualDate,expectedDate);
        driver.quit();
    }

    @Parameters({"URL"})
    @Test
    public void verifyDifferentSection(String url){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

       List<WebElement> options =driver.findElements(By.cssSelector("div[class=tabs]:nth-child(2) div"));
       for(int i = 0; i< options.size(); i++){
           options.get(i).click();
       }
       List<WebElement> title = driver.findElements(By.cssSelector("div[class*='tab-general'] img"));
        for (WebElement webElement : title) {
            System.out.println(webElement.getDomAttribute("title"));
        }
       driver.quit();
    }

    @Parameters({"URL"})
    @Test
    public void powerPriceGraph(String url){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(url);

        String heading = driver.findElement(By.xpath("(//div[@class='header-label'])[2]")).getText();
        String subHeading = driver.findElement((By.xpath("(//div[@class='header-sub-label'])[2]"))).getText();

        Assert.assertEquals(heading,"Power Price Forecast");
        Assert.assertEquals(subHeading,"Price by hour forecast");

        driver.quit();
    }

        @Test
        public void download() throws InterruptedException {

            String downloadPath = "C:\\Users\\mohdusmani\\Download";

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.default_directory", downloadPath);
            prefs.put("download.prompt_for_download", false);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);

            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            driver.get("https://seraopt-infield.serenticaglobal.com/dashboard/power-market-prices");

            File folder = new File(downloadPath);
            int before = folder.listFiles().length;

            driver.findElement(By.xpath("(//img[@alt='secondary icon'])[1]")).click();

            Thread.sleep(5000);

            int after = folder.listFiles().length;

            if (after > before) {
                System.out.println("File downloaded successfully!");
            } else {
                System.out.println("File not downloaded!");
            }
            driver.quit();
        }

        @Test
        public void specificDateSelect(){

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://seraopt-infield.serenticaglobal.com/dashboard/power-market-prices");

            driver.findElement(By.xpath("(//span[@class='ant-picker-selection-item-remove'])[1]")).click();

            String monthNumber = "6";
            String date = "15";
            String year = "2027";
            String[] expectedList = {monthNumber,date,year};

            driver.findElement(By.xpath("(//div[@class='date-picker'])[1]")).click();

            WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
            w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label='Choose a year']")));

            driver.findElement(By.cssSelector("button[aria-label='Choose a year']")).click();

            driver.findElement(By.xpath("//div[text()='"+year+"']")).click();

            List<WebElement> months = driver.findElements(By.xpath("//table[@class='ant-picker-content']/tbody/tr/td"));
            months.get(Integer.parseInt(monthNumber)-1).click();

            driver.findElement(By.xpath("//div[text()='"+date+"']")).click();
            driver.findElement((By.xpath("//span[text()='Apply']"))).click();
            System.out.println(driver.findElement(By.xpath("(//span[@class='ant-picker-selection-item'])[1]")).getText());
        }

        @Test
        public void dateRangeSelect(){

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get("https://seraopt-infield.serenticaglobal.com/dashboard/power-market-prices");
            driver.findElement(By.xpath("(//span[@class='ant-picker-selection-item-remove'])[1]")).click();
            driver.findElement(By.xpath("(//div[@class='date-picker'])[1]")).click();
            driver.findElement(By.cssSelector("div[title='Date Range']")).click();
            WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
            w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label='Choose a year']")));
            driver.findElement(By.cssSelector("button[aria-label='Choose a year']")).click();
            driver.findElement(By.xpath("//div[text()='2025']")).click();
            List<WebElement> months = driver.findElements(By.cssSelector("table[class='ant-picker-content'] tbody tr td"));
            months.get(8).click();
            driver.findElement(By.xpath("(//div[text()='1'])[1]")).click();
            driver.findElement(By.xpath("(//div[text()='10'])[1]")).click();

        }

    @Test
    public void testUpload1() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seraopt-infield.serenticaglobal.com/dashboard/power-market-prices");
        WebElement fileInput = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
        fileInput.sendKeys("C:\\Users\\mohdusmani\\download\\market-prices-forecast-2025-09-19-18-00-03.csv");
    }
}

