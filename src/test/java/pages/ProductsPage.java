package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ProductsPage extends BasePage{

    private final By TITLE = By.className("title");

    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']/ancestor::" +
            "div[@data-test='inventory-item']//button[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public void isPageOpened() {
         wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));


        List<WebElement> products = driver.findElements(By.id("products"));


        driver.switchTo().frame(driver.findElement(By.name("ifame")));
        driver.switchTo().defaultContent();


        WebElement element = driver.findElement(By.id("id"));
        Actions actions = new Actions(driver);



        File file = new File("src/test/resources/1.html");
        driver.findElement(By.cssSelector("[type=file]")).sendKeys(file.getAbsolutePath());

    }

    public void addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_PATTERN, product))).click();
    }

    public boolean isProductInCart(String product) {
        return driver.findElement(By.xpath(String.format("//*[@class='cart_item']//*[text()='%s']", product)))
                .isDisplayed();
    }



}
