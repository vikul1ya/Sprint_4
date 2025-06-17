package ru.practicum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class OrderPage {

    WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // локаторы страницы формы заказа

    By nameField = By.xpath(".//input[@placeholder = '* Имя']");// поле Имя
    By secondNameField = By.xpath(".//input[@placeholder = '* Фамилия']"); // поле фамилия
    By adressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");//поле адрес
    By metroField = By.xpath(".//input[@placeholder = '* Станция метро']"); // поле станция метро
    By telephoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");// локатор поля телефона

    By nextButton = By.xpath(".//button[text() = 'Далее']");// Кнопка далее
    By whenDeliveryField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");//поле когда привезти самокат
    By header = By.xpath(".//div[@class = 'Header_Header__214zg']");//шапка
    By rent = By.xpath(".//div[text() = '* Срок аренды']");//поле срок аренды
    By oneDays = By.xpath(".//div[@class = 'Dropdown-option' and text()= 'сутки']");//1 сутки
    By twoDays = By.xpath(".//div[@class = 'Dropdown-option' and text()= 'двое суток']");//2 суток
    By black = By.xpath("//*[@id='black']");
    By grey = By.xpath("//*[@id='grey']");
    By comment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");//поле комментарий
    By orderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text()='Заказать']");// кнопка заказать
    By confirmOrderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()= 'Да']");//кнопка подтверждения заказа "Да"
    By successMessage = By.xpath("//div[contains(text(),'Заказ оформлен')]");// локатор для всплывающего окна с подтверждением

    //локатор формы заказа для Ассертов
    By orderForm = By.xpath(".//div[@class ='Order_Content__bmtHS']");

    // Методы сраницы формы заказа

    // Метод перехода на страницу формы оформления заказа
    public void openOrderPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/order");
    }

    // Найти и заполнить поле Имя
    public void searchAndsendName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // Найти и заполнить поле Фамилия
    public void searchAndsendSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }

    // Найти и заполнить поле Адрес
    public void searchAndsendAdress(String adress) {
        driver.findElement(adressField).sendKeys(adress);
    }

    // Метод Найти и заполнить поле Телефон
    public void searchAndSendTelephone(String telephone) {
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    // поле станция Metro
    public void clickMetroField(String metro) {
        driver.findElement(metroField).sendKeys(metro);
        driver.findElement(By.cssSelector(".select-search__select")).click();
    }

    // Метод нажатия кнопки Далее
    public void searchAndClickNext(){
        driver.findElement(nextButton).click();
    }

    // Заполнение поля когда привезти самокат
    public void clickWhenDelivery(String date){
        driver.findElement(whenDeliveryField).sendKeys(date);
        driver.findElement(header).click();
    }

    //    Заполнение поля срок аренды
    public void rentalPeriodField(String period){
        driver.findElement(rent).click();

        if (period == "one") {
            driver.findElement(oneDays).click();
        } else if (period == "two") {
            driver.findElement(twoDays).click();
        }
    }

    //заполнение чекбокса цвет самоката
    public void selectColorBlack() {
        driver.findElement(black).click();
    }

    public void selectColorGrey() {
        driver.findElement(grey).click();
    }

    // заполнение поля комментарий
    public void commentDelivery(String message) {
        driver.findElement(comment).sendKeys(message);
    }

    //кнопка заказать
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //подтверждение заказа
    public void confirmOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmOrderButton)).click();
    }

    //метод получения формы заказа
    public boolean waitAndGetVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderForm)).isDisplayed();
    }

    public boolean isOrderSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }


}











