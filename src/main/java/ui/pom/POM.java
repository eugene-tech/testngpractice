package ui.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class POM {

    public WebDriver driver;

    POM(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
