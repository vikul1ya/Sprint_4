
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.practicum.DriverFactory;
import ru.practicum.MainPage;


// новый код с параметризацией
@RunWith(Parameterized.class)
public class MainPageAccordionTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    private static WebDriver driver;
    private final By clickText;
    private final By answer;
    private final String text;


    public MainPageAccordionTest(By clickText, By answer, String text) {
        this.clickText = clickText;
        this.answer = answer;
        this.text = text;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getAccordion() {
        MainPage mainPage = new MainPage(driver);
        return new Object[][]{
                {mainPage.getAccordionQuest1(), mainPage.getAnswer1(), mainPage.getText1()},
                {mainPage.getAccordionQuest2(), mainPage.getAnswer2(), mainPage.getText2()},
                {mainPage.getAccordionQuest3(), mainPage.getAnswer3(), mainPage.getText3()},
                {mainPage.getAccordionQuest4(), mainPage.getAnswer4(), mainPage.getText4()},
                {mainPage.getAccordionQuest5(), mainPage.getAnswer5(), mainPage.getText5()},
                {mainPage.getAccordionQuest6(), mainPage.getAnswer6(), mainPage.getText6()},
                {mainPage.getAccordionQuest7(), mainPage.getAnswer7(), mainPage.getText7()},
                {mainPage.getAccordionQuest8(), mainPage.getAnswer8(), mainPage.getText8()}
        };
    }

    @Test
    public void testAccordion() throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookie();
        mainPage.skrollAccordion();
        mainPage.clickButton(clickText);
        mainPage.textContentChecking(answer, text);

    }

}
