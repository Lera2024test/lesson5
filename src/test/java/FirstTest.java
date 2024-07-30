import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({AllureTestNg.class})
public class FirstTest {

    private WebDriver driver;

    @BeforeTest
    void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/calculator");
    }

    @Test
    public void myTest(){

        WebElement firstNumberElement = driver.findElement(By.id("number1"));
        firstNumberElement.sendKeys("2");

        WebElement secondNumberElement = driver.findElement(By.name("number2"));
        secondNumberElement.sendKeys("7");

        WebElement submitButton = driver.findElement(By.xpath("//input[@id=\"calculate\"]"));
        submitButton.click();

        WebElement answer = driver.findElement(By.id("answer"));

        Assert.assertEquals(answer.getText(), "9", "The result is incorrect, should be 9");
    }

    @AfterTest
    void closeDriver(){
        driver.quit();
    }



}