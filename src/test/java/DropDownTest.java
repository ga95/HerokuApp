import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class DropDownTest {

    WebDriver driver = new ChromeDriver();
    @BeforeMethod
    public void setup(){
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }
    //В разработчке!
    @Test
    public void checkDropDown() throws InterruptedException {

        /*
        int i = 0;

        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByIndex(1);
        List<WebElement> list = select.getOptions();
        for (WebElement element: list){
            System.out.println(element.getText());
            i++;
        }

        for (i = 0, i=i+1 ){


        }


        // Найти элемент dropdown по его селектору (например, id или class)
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);

        // Задать значение для выбора
        String expectedValue = element.getText(); // Текст ожидаемого элемента

        // Выбор значения в dropdown (если это необходимо)
        dropdown.selectByVisibleText(expectedValue);

        // Проверка, что выбранный элемент соответствует ожидаемому
        String selectedOption = dropdown.getFirstSelectedOption().getText();

        if (selectedOption.equals(expectedValue)) {
            System.out.println("Выбранный элемент соответствует ожидаемому: " + selectedOption);
        } else {
            System.out.println("Ошибка: Выбранный элемент не соответствует ожидаемому. " +
                    "Выбранный: " + selectedOption + ", Ожидаемый: " + expectedValue);
        }


        // Задать значение для выбора
        String expectedValue2 = "Option 2"; // Текст ожидаемого элемента

        // Выбор значения в dropdown (если это необходимо)
        dropdown.selectByVisibleText(expectedValue2);

        // Проверка, что выбранный элемент соответствует ожидаемому
        String selectedOption2 = dropdown.getFirstSelectedOption().getText();

        if (selectedOption.equals(expectedValue2)) {
            System.out.println("Выбранный элемент соответствует ожидаемому: " + selectedOption);
        } else {
            System.out.println("Ошибка: Выбранный элемент не соответствует ожидаемому. " +
                    "Выбранный: " + selectedOption2 + ", Ожидаемый: " + expectedValue2);
        }*/

        WebElement dropdown = driver.findElement(By.id("dropdown"));

        Select dd = new Select(dropdown);

        dd.selectByVisibleText("Option 1");

        Thread.sleep(1000);

        dd.selectByVisibleText("Option 2");



/*
        Select select = new Select(driver.findElement(By.id("dropdown")));

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);



        select.selectByIndex(1);
        select.equals("Option 1");


        Thread.sleep(5000);
        select.selectByIndex(2);
        select.equals("Option 2");
        Thread.sleep(5000);*/
    }
    @AfterTest
    public void thearDown(){
        driver.quit();
    }
}
