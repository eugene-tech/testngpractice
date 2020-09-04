package ui.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Moldova extends POM {

    private static final String MAIN_URL = "https://moldova.md/ro";


    @FindBy(xpath = "//a[contains(@class, 'navbar-brand')]")
    public WebElement mainLink;

    @FindBy(className = "slogan")
    public WebElement officialPage;

    @FindBy(css = "input.form-text")
    public WebElement searchInput;


    private Moldova(WebDriver driver) {
        super(driver);
    }

    public static Moldova init(WebDriver driver) {
        driver.get(MAIN_URL);
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Moldova(driver);
    }

    /**
     * @param language code (en, ru, ro)
     */
    public void setLanguage(String language) {
        driver.findElement(By.xpath("//li[contains(concat(' ', @class, ' '),' " + language + " ')]/a")).click();
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement getMenuLink(String link) {
        try {
            return driver.findElement(By.xpath("//nav//a[not(ancestor::ul[@class='dropdown-menu']) and text()='" + link + "']"));
        } catch (NoSuchElementException ignored) {
            Assert.fail("'" + link + "' not found");
            return null;
        }
    }
}
