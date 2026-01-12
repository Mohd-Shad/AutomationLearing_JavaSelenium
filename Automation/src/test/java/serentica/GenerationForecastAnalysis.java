package serentica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class GenerationForecastAnalysis {

    @Test
    public void headings(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seraopt-infield.serenticaglobal.com/dashboard/power-market-prices");

        driver.findElement(By.cssSelector(".tab-general:nth-child(2)")).click();

        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        //w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tab-general:nth-child(2)")));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class=tabs]:nth-child(2) div:nth-child(2)")));

        String heading = driver.findElement(By.cssSelector(".header-label")).getText();
        String subHeadng = driver.findElement((By.cssSelector(".header-sub-label"))).getText();

        Assert.assertEquals(heading,"Generation Forecast Analysis");
        Assert.assertEquals(subHeadng,"Forecasted power generation insights for planning and optimization.");

        driver.quit();
    }

    @Test
    public void search(){

        String spv = "Koppal Serentica - SRI1PL";
        String resource = "SOLAR";

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seraopt-infield.serenticaglobal.com/dashboard/power-market-prices");

        driver.findElement(By.cssSelector(".tab-general:nth-child(2)")).click();

        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tab-general:nth-child(2)")));

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ant-select-selector'])[1]")));
        driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[1]")).click();
        driver.findElement(By.xpath("//span[text()='"+spv+"']")).click();

        driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[2]")).click();
        driver.findElement((By.xpath("//span[text()='"+resource+"']"))).click();

        driver.findElement(By.cssSelector(".ant-picker-selection-item-remove")).click();
        String monthNumber = "9";
        String date = "3";
        String year = "2025";
        String[] expectedList = {monthNumber,date,year};

        //w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-picker-selection-overflow")));
        driver.findElement(By.cssSelector(".date-picker")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label='Choose a year']")));
        driver.findElement(By.cssSelector("button[aria-label='Choose a year']")).click();
        driver.findElement(By.xpath("//div[text()='"+year+"']")).click();
        List<WebElement> months = driver.findElements(By.xpath("//table[@class='ant-picker-content']/tbody/tr/td"));
        months.get(Integer.parseInt(monthNumber)-1).click();
        driver.findElement(By.xpath("//div[text()='"+date+"']")).click();
        driver.findElement((By.xpath("//span[text()='Apply']"))).click();
        System.out.println(driver.findElement(By.xpath("//span[@class='ant-picker-selection-item']")).getText());
        driver.findElement(By.cssSelector("div[aria-label='Choose data type'] label:last-child")).click();
        driver.quit();
    }
}
