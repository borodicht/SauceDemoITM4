package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {

     protected final String BASE_URL = "https://www.saucedemo.com/";

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void elementShouldNotExist(By element) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        int numbersOfElement = driver.findElements(element).size();
        Assert.assertEquals(numbersOfElement, 0);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
