package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    WebDriver driver; // Объявление переменной driver для управления браузером через WebDriver
    SoftAssert softAssert;
    LoginPage loginPage;
    ProductsPage productsPage;

    String user = System.getProperty("user");
    String password = System.getProperty("password");

    @BeforeMethod
    public void setup() {
        softAssert = new SoftAssert();
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--headless");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        softAssert = new SoftAssert();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {

        }
        if (driver != null) {
            driver.quit();
        }
    }
}
