package ui.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {

    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";

    public static WebDriver getDriver() {
        System.setProperty(CHROME_PROPERTY, getChromePath());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static String getChromePath() {
        return String.join("\\", System.getProperty("user.dir"), "drivers", "chromedriver.exe");
    }
}
