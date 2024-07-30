import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Rozetka {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://rozetka.com.ua/");
            WebElement searchBox = driver.findElement(By.name("search"));
            searchBox.sendKeys("computer");
            searchBox.submit();

            WebElement searchButton = driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']"));
            searchButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Gran Turismo Sport")));

            WebElement granTurismoLink = driver.findElement(By.partialLinkText("Gran Turismo Sport"));
            granTurismoLink.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".product-page_title")));

            WebElement productTitle = driver.findElement(By.cssSelector(".product-page_title"));
            String titleText = productTitle.getText();

            Assert.assertTrue(titleText.contains("Gran Turismo Sport"), "The product page title does not contain 'Gran Turismo Sport'");

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
    private static void serchBox() {
    }
}
