package pages;

import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;


    @BeforeTest
    public void initializeDriver(){
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
