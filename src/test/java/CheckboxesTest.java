
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
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

       //изначально проверяем, что чекбокс выключен
        Assert.assertFalse(checkbox.isSelected ());
        if (!checkbox.isSelected()) {
            //кликаем по чекбоксу
            checkbox.click();

            if (checkbox.isSelected()) {
                //Проверяем, что чекбокс кликнут
                Assert.assertTrue(checkbox.isSelected ());
                                       }
            else {
                //Проверяем, что чекбокс не кликнулся
                Assert.assertFalse(checkbox.isSelected ());
                //Кликам еще раз по чекбоксу
                checkbox.click();
                 }
        }

        //Поиск чекбокса и выключение его
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

            //Проверяем, что изначально чекбокс включен
            Assert.assertTrue(checkbox2.isSelected ());

        if (checkbox2.isSelected()) {
            //кликаем по чекбоксу
            checkbox2.click();
            if (!checkbox2.isSelected()) {
                //Проверяем, что чекбокс выключился
                Assert.assertFalse(checkbox2.isSelected ());
            }
        } else {
            //Проверяем, что чекбокс не кликнулся
            Assert.assertFalse(checkbox.isSelected ());
            //Кликам еще раз по чекбоксу
            checkbox2.click();
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
