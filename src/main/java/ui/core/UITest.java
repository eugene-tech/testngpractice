package ui.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Optional;

public class UITest {

    public static WebDriver driver;

    @BeforeClass
    public void initDriver() {
        driver = DriverHelper.getDriver();
    }

    @AfterClass
    public void closeDriver() {
        Optional.ofNullable(driver).ifPresent(WebDriver::close);
    }

    @BeforeMethod
    @AfterMethod
    public void deleteAllCookies() {
        if (driver != null)
            driver.manage().deleteAllCookies();
    }
}
