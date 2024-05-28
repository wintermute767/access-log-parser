package ru.kotov.autotests;

import lombok.SneakyThrows;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GoogleTests {
    WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options);
        this.driver.get("https://google.com/");
        this.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    @SneakyThrows
    public void pobedaSiteCheck() {
        driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).click();
        driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).sendKeys("Сайт компании Победа");
        driver.findElement(By.cssSelector("[aria-label=\"Найти\"]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#__next > div.dp-lw1vya-root > main > div > div > div.dp-44pqo6-root > div > div.dp-98fis2-inner > button:nth-child(11) > img"))));
        Assert.assertEquals(driver.findElement(By.cssSelector("#__next > div.dp-lw1vya-root > main > div > div > div.dp-44pqo6-root > div > div.dp-98fis2-inner > button:nth-child(11) > div.dp-5eg981-root-inner > div > div")).getText(), "Полетели в Калининград!");

        driver.findElement(By.cssSelector("#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-4d364c-root-root > div.dp-yqmup9-root > button.dp-1yj5213-root-root")).click();
        driver.findElement(By.cssSelector("body > div.dp-1np90yx-root-root > div > div > button:nth-child(2)")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(wait1
                .until(ExpectedConditions
                        .textToBePresentInElement(driver
                                .findElement(By
                                        .cssSelector("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div.dp-1v2wfuc-root-root-tabs > div.dp-1n9plpp-root-group > button:nth-child(1) > div.dp-YpbSQV-textVisible-ref.dp-1glhebn-root-textVisible")),
                                "Ticket search")));
        Assert.assertTrue(wait1
                .until(ExpectedConditions
                        .textToBePresentInElementLocated(By.cssSelector("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div.dp-1v2wfuc-root-root-tabs > div.dp-1n9plpp-root-group > button:nth-child(2) > div.dp-YpbSQV-textVisible-ref.dp-1glhebn-root-textVisible"),
                                "Online check-in")));

    Assert.assertTrue(wait1
                .until(ExpectedConditions
                        .textToBePresentInElementLocated(By.cssSelector("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div.dp-1v2wfuc-root-root-tabs > div.dp-1n9plpp-root-group > button:nth-child(3) > div.dp-YpbSQV-textVisible-ref.dp-1glhebn-root-textVisible"),
                                "Manage my booking")));

    }


}
