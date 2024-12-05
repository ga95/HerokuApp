import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AddRemoveTest {

    WebDriver driver;
    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void checkAddRemoveElemetnts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        //открыть странцу с заданием
        driver.findElement(By.xpath("//a[.='Add/Remove Elements']")).click();
        //нажать на кнопку добавить элемент
        driver.findElement(By.xpath("//button[.='Add Element']")).click();
        //нажать на кнопку добавить элемент
        driver.findElement(By.xpath("//button[.='Add Element']")).click();
        //найти все кнопки удалить
        List<WebElement> elements = driver.findElements(By.xpath("//button[.='Delete']"));
        // Подсчет количества кнопок удалить
        int count = elements.size();
        //проверяем, что кнопок было добавлено 2 штуки
        Assert.assertEquals(count, 2);
        //нажать на кнопку удалить элемент
        driver.findElement(By.xpath("//button[.='Delete']")).click();
        //найти все кнопки удалить
        List<WebElement> elements2 = driver.findElements(By.xpath("//button[.='Delete']"));
        // Подсчет количество кнопок удалить
        int count2 = elements2.size();
        //проверяем, что кнопка осталась только 1 штука
        Assert.assertEquals(count2, 1);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();


    }

}
