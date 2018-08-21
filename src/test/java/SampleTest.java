import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SampleTest {

    @Test
    private void seleniumTest(){
        System.setProperty("webdriver.chrome.driver","C:/Users/Tharindu/IdeaProjects/Selenium/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://demoqa.com/");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("menu-item-374")).click();

        driver.findElement(By.name("first_name")).sendKeys("Tharindu");
        driver.findElement(By.name("last_name")).sendKeys("Jayathilake");
        driver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[2]/div/div/input[1]")).click();

        List<WebElement> radioButton = driver.findElements(By.name("checkbox_5[]"));
        radioButton.get(2).click();
        radioButton.get(1).click();

        WebElement dropDown = driver.findElement(By.name("dropdown_7"));
        Select dropElemtnt = new Select(dropDown);
        dropElemtnt.selectByIndex(2);

        WebElement dropDownMonth = driver.findElement(By.name("date_8[date][mm]"));
        Select dropElemtntMonth = new Select(dropDownMonth);
        dropElemtntMonth.selectByIndex(5);

        WebElement dropDownDay = driver.findElement(By.name("date_8[date][dd]"));
        Select dropElemtntDay = new Select(dropDownDay);
        dropElemtntDay.selectByIndex(7);

        WebElement dropDownYr = driver.findElement(By.name("date_8[date][yy]"));
        Select dropElemtntYr = new Select(dropDownYr);
        dropElemtntYr.selectByIndex(7);

        driver.findElement(By.name("phone_9")).sendKeys("0771412856");
        driver.findElement(By.name("username")).sendKeys("tharindu55");
        driver.findElement(By.name("e_mail")).sendKeys("pqre@wec.cpm");
        driver.findElement(By.name("password")).sendKeys("Fit@14@itfac.mert.ac.lk");
        driver.findElement(By.id("confirm_password_password_2")).sendKeys("Fit@14@itfac.mert.ac.lk");
        driver.findElement(By.name("pie_submit")).click();
    }
}
