package ru.practicum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы стартовой страницы

    // локатор кнопки входа в приложение
    By topButton = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]");
    By bottomButton = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");
    // локатор выпадающего списка
    By Accordion = By.xpath("/html/body/div/div/div/div[5]/div[2]/div");


    //Методы начальной сраницы

    //метод открытия страницы
    public void openMainPage(){
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    //метод скролл до выпадающего списка
    public void skrollAccordion(){
        WebElement element = driver.findElement(Accordion);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    //метод получения вопросов и ответов
    public void getAccordion(){

        // Получаем все вопросы
        List<WebElement> headers = driver.findElements(By.className("accordion__heading"));

        // Получаем все ответы
        List<WebElement> answers = driver.findElements(By.className("accordion__panel"));

        // Проходимся по каждому вопросу
            for (int i = 0; i < headers.size(); i++) {
                // Прокручиваем к вопросу
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", headers.get(i));

            // Ожидание
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(headers.get(i)));

            // Кликаем по вопросу
            headers.get(i).click();

           // Ожидание
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOf(answers.get(i)));

            String[] expectedAnswers = {
                    "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области."
            };

            // Проверяем ответ
            String actualAnswerText = answers.get(i).getText().trim();
            Assert.assertEquals("Текст ответа не совпадает для вопроса №" + (i + 1),
                    expectedAnswers[i], actualAnswerText);

        }

    }

    //методы кнопок
    public void clickOrderButton(String button) {
        if(button == "top") {
            driver.findElement(topButton).click();
        } else if (button == "bottom") {
            WebElement element = driver.findElement(bottomButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        }
    }


}
