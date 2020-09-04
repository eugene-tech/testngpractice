package ui.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.core.UITest;
import ui.pom.Moldova;

import java.util.Arrays;
import java.util.List;

public class LanguageTest extends UITest {

    private static final List<String> RO_MENU = Arrays.asList("Despre Republica Moldova", "Noutăți", "Instituții de Stat",
        "Economie", "Educație", "Relații Internaționale");

    @DataProvider
    public static Object[][] menuItems() {
        return new Object[][]{
            {"ro", RO_MENU}
            // TODO: add all languages
        };
    }

    @Test(description = "RM-100", dataProvider = "menuItems")
    public void menu(String language, List<String> links) {
        Moldova moldova = Moldova.init(driver);
        moldova.setLanguage(language);
        for (String link : links) {
            Assert.assertTrue(moldova.getMenuLink(link).isDisplayed(), link + " not displayed");
        }
    }

    // TODO: implement below ui.tests


    @Test(description = "RM-100")
    public void slogan() {}

    @Test
    public void government() {}

    @Test
    public void tourism() {}

    @Test
    public void currency() {}

    @Test
    public void weather() {}
}
