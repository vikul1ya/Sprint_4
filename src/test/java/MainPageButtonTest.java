
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.practicum.DriverFactory;
import ru.practicum.MainPage;
import ru.practicum.OrderPage;

import static org.junit.Assert.assertTrue;


// новый код с параметризацией
@RunWith(Parameterized.class)
public class MainPageButtonTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    private static WebDriver driver;
    private final String type;


    public MainPageButtonTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getTypeButton() {
        return new Object[][] {
                {"top"},
                {"bottom"}
        };
    }


    @Test
    public void testOrderButton() {
        WebDriver driver = DriverFactory.getDriver();
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        mainPage.closeCookie();
        mainPage.clickOrderButton(type);

        boolean orderFormIsVisible = orderPage.waitAndGetVisible();
        assertTrue("Форма заказа должна отображаться после нажатия на кнопку " + type, orderFormIsVisible);
    }

}
