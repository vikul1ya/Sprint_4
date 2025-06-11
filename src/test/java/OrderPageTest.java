import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.practicum.DriverFactory;
import ru.practicum.OrderPage;



@RunWith(Parameterized.class)
public class OrderPageTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    private final String nameField;
    private final String secondNameField;
    private final String adressField;
    private final String telephoneField;
    private final String metroField;
    private final String whenDeliveryField;
    private final String period;
    private final boolean isBlack;
    private final boolean isGrey;
    private final String comment;



    public OrderPageTest(
            String nameField,
            String secondNameField,
            String adressField,
            String metroField,
            String telephoneField,
            String whenDeliveryField,
            String period,
            boolean isBlack,
            boolean isGrey,
            String comment

    ) {
        this.nameField = nameField;
        this.secondNameField = secondNameField;
        this.adressField = adressField;
        this.metroField = metroField;
        this.telephoneField = telephoneField;
        this.whenDeliveryField = whenDeliveryField;
        this.period = period;
        this.isBlack = isBlack;
        this.isGrey = isGrey;
        this.comment = comment;

    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getOrderName() {
        return new Object[][]{
                {"Виктория", "Соколова", "ул.Мусоргского,5", "Красносельская", "89046350516", "01.07.2025", "one", true, false, "комментарий"},
                {"Ольга", "Стадник", "ул.Ленина,3", "Охотный Ряд", "89931598879", "20.07.2025", "two", false, true, "Позвонить в звонок"},

        };
    }


    @Test
    public void testOrderForm() throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver();
        OrderPage orderPage = new OrderPage(driver);

        //заполнение формы заказа стр1
        orderPage.openOrderPage();
        orderPage.searchAndsendName(nameField);
        orderPage.searchAndsendSecondName(secondNameField);
        orderPage.searchAndsendAdress(adressField);
        orderPage.clickMetroField(metroField);
        orderPage.searchAndSendTelephone(telephoneField);
        orderPage.searchAndClickNext();

        //заполнение формы заказа стр2
        orderPage.clickWhenDelivery(whenDeliveryField);
        orderPage.rentalPeriodField(period);
        if (isBlack) orderPage.selectColorBlack();
        if (isGrey) orderPage.selectColorGrey();
        orderPage.commentDelivery(comment);
        orderPage.clickOrderButton();
        orderPage.confirmOrder();
      // Проверка успешного оформления заказа
        Assert.assertTrue("Заказ не подтвержден", orderPage.isOrderSuccess());
    }
}



