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
        //Перейти по ссылки задания
        driver.findElement(By.linkText("Inputs")).click();

        WebElement num_field = driver.findElement(By.xpath("//input[@type='number']"));
        //Провекра #1 вводим различные значения в поле
        for (int i = 0; i < 10; i++) {

            Random rand = new Random();
            // Генерация двухзначного рандомного числа
            int values = rand.nextInt(90) + 10;
            String value = String.valueOf(values);
            num_field.sendKeys(value);
            num_field.clear();
        }

        //Проверка #2 вводим значение и поднимаем его при помощи кнопок
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            num_field.sendKeys(Keys.ARROW_UP);
        }

        num_field.clear();

        // Проверка #3 вводим значение и опускаем его при помощи кнопок
        for (int i = 0; i < 10; i++) {
            num_field.sendKeys(Keys.ARROW_DOWN);
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
