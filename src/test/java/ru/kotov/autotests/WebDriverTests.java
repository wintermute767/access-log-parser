package ru.kotov.autotests;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class WebDriverTests {
    WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://pikabu.ru/");
        driver.manage().deleteAllCookies();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void pikabuSiteHeaderCheck() {
        String title = driver.getTitle();
        log.info(title);
        Assert.assertEquals(title, "Горячее – самые интересные и обсуждаемые посты | Пикабу");

    }

    @Test
    public void pikabuAuthorizationBlockDisplayCheck() {
        driver.findElement(By.cssSelector("[class=\"header-right-menu__login-button\"]")).click();
        WebElement authorizationBlock = driver.findElement(By.xpath("//div[contains(@class, 'popup__content')]"));
        WebElement loginElement = authorizationBlock.findElement(By.xpath(".//input[@name='username']"));
        WebElement passwordElement = authorizationBlock.findElement(By.xpath(".//input[@name='password']"));
        WebElement enterButton = authorizationBlock.findElement(By.xpath(".//button[@type='submit']"));

        Assert.assertEquals(authorizationBlock.isDisplayed(), true);
        Assert.assertEquals(loginElement.getAccessibleName(), "Логин");
        Assert.assertEquals(passwordElement.getAccessibleName(), "Пароль");
        Assert.assertEquals(enterButton.getText(), "Войти");
    }
    @Test
    @SneakyThrows
    public void pikabuAuthorizationBlockWithIncorrectLoginAndPasswordCheck() {
        driver.findElement(By.cssSelector("[class=\"header-right-menu__login-button\"]")).click();

        WebElement auth = driver.findElement(By.xpath("//div[contains(@class, 'popup__content')]"));
        WebElement login = auth.findElement(By.xpath(".//input[@name='username']"));
        WebElement password = auth.findElement(By.xpath(".//input[@name='password']"));
        WebElement enter = auth.findElement(By.xpath(".//button[@type='submit']"));

        login.sendKeys("Qwerty");
        password.sendKeys("Qwerty");
        Thread.sleep(1000);
        enter.click();
        Thread.sleep(20000);
        WebElement ErrorLogin = driver.findElement(By.xpath("//div[5]/div/div[1]/div/div[1]/div/span"));

        Assert.assertEquals(ErrorLogin.isDisplayed(), true);
        Assert.assertEquals(ErrorLogin.getText(), "Ошибка. Вы ввели неверные данные авторизации");
    }

}