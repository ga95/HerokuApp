import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        driver.findElement(By.xpath("//a[.='Add/Remove Elements']")).click();
       // Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='Add Element']")).click();
       // Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='Add Element']")).click();
       // Thread.sleep(2000); что бы сделать коммит

        List<WebElement> elements = driver.findElements(By.xpath("//button[.='Delete']"));
        // Подсчет количества одинаковых элементов
        int count = elements.size();
        System.out.println("Количество элементов до удаления: " + count);

        driver.findElement(By.xpath("//button[.='Delete']")).click();
        Thread.sleep(2000);


        List<WebElement> elements2 = driver.findElements(By.xpath("//button[.='Delete']"));
        // Подсчет количества одинаковых элементов
        int count2 = elements2.size();
        System.out.println("Количество элементов после удаления: " + count2);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();


    }

}
