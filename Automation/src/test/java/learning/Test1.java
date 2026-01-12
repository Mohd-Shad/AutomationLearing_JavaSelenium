package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://seraopt-infield.serenticaglobal.com/dashboard/power-market-prices");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getCurrentUrl(),"https://seraopt-infield.serenticaglobal.com/dashboard/power-market-prices");


    }
}
