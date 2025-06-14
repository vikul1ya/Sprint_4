package ru.practicum;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;


public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // локатор кнопки входа в приложение
    By topButton = By.xpath("//*[@id='root']/div/div/div[1]/div[2]/button[1]");
    By bottomButton = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");
    // локатор выпадающего списка
    By Accordion = By.xpath("//*[@id='root']/div/div/div[5]/div[2]/div");
    //локатор кнопки закрытия Куки "Да все привыкли"
    By cookiButton = By.xpath("//*[@id='rcc-confirm-button']");

    //локаторы ответов аккордеона
    By Answer1 = By.xpath("//*[@id='accordion__panel-0']");
    By Answer2 = By.xpath("//*[@id='accordion__panel-1']");
    By Answer3 = By.xpath("//*[@id='accordion__panel-2']");
    By Answer4 = By.xpath("//*[@id='accordion__panel-3']");
    By Answer5 = By.xpath("//*[@id='accordion__panel-4']");
    By Answer6 = By.xpath("//*[@id='accordion__panel-5']");
    By Answer7 = By.xpath("//*[@id='accordion__panel-6']");
    By Answer8 = By.xpath("//*[@id='accordion__panel-7']");
    //локаторы вопросов аккордеона

    By Quest1 = By.id("accordion__heading-0");
    By Quest2 = By.id("accordion__heading-1");
    By Quest3 = By.id("accordion__heading-2");
    By Quest4 = By.id("accordion__heading-3");
    By Quest5 = By.id("accordion__heading-4");
    By Quest6 = By.id("accordion__heading-5");
    By Quest7 = By.id("accordion__heading-6");
    By Quest8 = By.id("accordion__heading-7");

    String text1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    String text2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    String text3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    String text4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    String text5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    String text6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    String text7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    String text8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //метод закрытия всплывающего окна куки
    public void closeCookie() {
        driver.findElement(cookiButton).click();
    }

    //метод скролл до выпадающего списка
    public void skrollAccordion() {
        WebElement element = driver.findElement(Accordion);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    //метод проверки содержания текста
    public void textContentChecking(By element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(driver -> (driver.findElement(element).getText().length() != 0));
        MatcherAssert.assertThat(driver.findElement(element).getText(), containsString(text));
    }

    public void clickButton(By button) {
        WebElement element = driver.findElement(button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(button).click();
    }


    //методы кнопок
    public void clickOrderButton(String button) {
        if (button == "top") {
            driver.findElement(topButton).click();
        } else if (button == "bottom") {
            WebElement element = driver.findElement(bottomButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            element.click();
        }
    }



    //Геттеры
    public By getAccordionQuest1() {
        return Quest1;
    }

    public By getAccordionQuest2() {
        return Quest2;
    }

    public By getAccordionQuest3() {
        return Quest3;
    }

    public By getAccordionQuest4() {
        return Quest4;
    }

    public By getAccordionQuest5() {
        return Quest5;
    }

    public By getAccordionQuest6() {
        return Quest6;
    }

    public By getAccordionQuest7() {
        return Quest7;
    }

    public By getAccordionQuest8() {
        return Quest8;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getText3() {
        return text3;
    }

    public String getText4() {
        return text4;
    }

    public String getText5() {
        return text5;
    }

    public String getText6() {
        return text6;
    }

    public String getText7() {
        return text7;
    }

    public String getText8() {
        return text8;
    }

    public By getAnswer8() {
        return Answer8;
    }

    public By getAnswer7() {
        return Answer7;
    }

    public By getAnswer6() {
        return Answer6;
    }

    public By getAnswer5() {
        return Answer5;
    }

    public By getAnswer4() {
        return Answer4;
    }

    public By getAnswer3() {
        return Answer3;
    }

    public By getAnswer2() {
        return Answer2;
    }

    public By getAnswer1() {
        return Answer1;
    }


}
