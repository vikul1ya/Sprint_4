
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.practicum.DriverFactory;
import ru.practicum.MainPage;

public class MainPageTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void testAccordion() {
        WebDriver driver = DriverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.skrollAccordion();
        mainPage.getAccordion();
    }

    @Test
    public void testOrderButton1() {
        WebDriver driver = DriverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.clickOrderButton("top");
    }

    @Test
    public void testOrderButton2() {
        WebDriver driver = DriverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.clickOrderButton("bottom");
    }

}
