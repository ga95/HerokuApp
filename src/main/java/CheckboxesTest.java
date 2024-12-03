
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTest {

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
        driver.findElement(By.linkText("Checkboxes")).click();

        //Поиск чекбокса и включение его

        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        Thread.sleep(3000); //только для наглядности при запуске
        if (!checkbox.isSelected()) {
            System.out.println("Действие первое!");
            System.out.println("Чекбокс не отмечен (unchecked).");
            checkbox.click();
            Thread.sleep(3000); //только для наглядности при запуске
            if (checkbox.isSelected()) {
                System.out.println("Теперь чекбокс отмечен (checked).");}
            Thread.sleep(3000); //только для наглядности при запуске
        } else {
            System.out.println("Чекбокс отмечен (checked).");
            checkbox.click();
            Thread.sleep(3000); //только для наглядности при запуске
        }

        //Поиск чекбокса и выключение его
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        if (checkbox2.isSelected()) {
            System.out.println("Действие второе!");
            System.out.println("Чекбокс отмечен (checked).");
            checkbox2.click();
            Thread.sleep(3000); //только для наглядности при запуске
            if (!checkbox2.isSelected()) {
                System.out.println("Теперь чекбокс не отмечен (unchecked).");
                Thread.sleep(3000); //только для наглядности при запуске

            }
        } else {
            System.out.println("Чекбокс не отмечен (unchecked).");
            checkbox2.click();
            Thread.sleep(3000); //только для наглядности при запуске
        }

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();


    }
}
