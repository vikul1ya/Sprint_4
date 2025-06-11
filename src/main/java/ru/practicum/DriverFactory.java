package ru.practicum;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory extends ExternalResource {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public void initDriver(){
        if("firefox".equals(System.getProperty("browser"))){
            startFirefox();
        }else {
            startChrome();
        }

    }

    private void startChrome(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize(); // на весь экран
    }

    private void startFirefox(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize(); // на весь экран

    }

    @Override
    protected void before() throws Throwable {
        initDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }
}