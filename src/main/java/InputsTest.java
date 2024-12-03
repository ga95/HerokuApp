
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputsTest{

    WebDriver driver;
    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000)); //Не явное ожидание
    }
    @Test
    public void checkAddRemoveElemetnts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        //Click on Checkboxes Link
        driver.findElement(By.linkText("Inputs")).click();

        WebElement num_field = driver.findElement(By.xpath("//input[@type='number']"));
        //Scenario 1: Random fill number  in Number textfield
        for (int i = 0; i < 10; i++) {

            Random rand = new Random();
            // Generate a random two-digit number
            int values = rand.nextInt(90) + 10;
            String value = String.valueOf(values);
            num_field.sendKeys(value);
            Thread.sleep(1000);
            num_field.clear();
        }

        //Scenario 2 : Enter a number with the help of Increment Arrow
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            num_field.sendKeys(Keys.ARROW_UP);
        }

        Thread.sleep(1000);

        num_field.clear();

        //Scenario 3 : Enter a number with the help of Decrement Arrow
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            num_field.sendKeys(Keys.ARROW_DOWN);
        }

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();


    }
}
