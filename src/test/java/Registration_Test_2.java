import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Registration_Test_2 {
    static WebDriver driver;
    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("WebDriver.ChromeDriver","G:\\Moodle\\L4S1\\IT Quality Assurance\\Labs\\SelNewFit14\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("__disable_notifications");
        options.addArguments("disable-infobars");

        driver = new ChromeDriver(options);
        driver.get("http://demoqa.com");

        driver.manage().window().maximize();
        driver.findElement(By.id("menu-item-374")).click();
    }


    @Test (dataProvider = "getDataForName" , priority = 1)
    public void enterSendKeyDataForName(String name, String value) throws Exception {
        driver.findElement(By.name(name)).sendKeys(value);
    }

    @Test (dataProvider = "getDataForID" , priority = 2)
    public void enterSendKeyDataForID(String id, String value) throws Exception {
        driver.findElement(By.id(id)).sendKeys(value);
    }

    @Test (priority = 3)
    public void checkRegistration() throws Exception {
        List<WebElement> radioButton = driver.findElements(By.name("radio_4[]"));
        radioButton.get(2).click();

        List<WebElement> checkboxes = driver.findElements(By.name("checkbox_5[]"));
        checkboxes.get(1).click();

        WebElement dropdown = driver.findElement(By.name("dropdown_7"));
        Select dropdownelement = new Select(dropdown);
        dropdownelement.selectByValue("Sri Lanka");


        WebElement birthMonth = driver.findElement(By.id("mm_date_8"));
        Select ddBirthMonth = new Select(birthMonth);
        ddBirthMonth.selectByValue("10");
        WebElement birthDay = driver.findElement(By.id("dd_date_8"));
        Select ddBirthDay = new Select(birthDay);
        ddBirthDay.selectByValue("20");
        WebElement birthYear = driver.findElement(By.id("yy_date_8"));
        Select ddBirthYear = new Select(birthYear);
        ddBirthYear.selectByValue("1993");

        driver.findElement(By.name("pie_submit")).click();

        Thread.sleep(5000);

        String message = driver.findElement(By.xpath("//*[@id=\"post-49\"]/div/p")).getText();
        Assert.assertEquals(message, "Thank you for your registration");
        System.out.println(message);
    }

    @DataProvider
    public Object [][] getDataForName() {
        return new Object[][]{
                {"first_name","Tharindu"},
                {"last_name","Jayathilake"}
        };
    }

    @DataProvider
    public Object [][] getDataForID() {
        return new Object[][]{
                {"phone_9","0774854264"},
                {"username","AnyUserInUniverse2"},
                {"email_1", "anyuser@universe2.com"},
                {"password_2","12345welcome"},
                {"confirm_password_password_2", "12345welcome"},
                {"description","This is a sample text"}
        };
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

}
