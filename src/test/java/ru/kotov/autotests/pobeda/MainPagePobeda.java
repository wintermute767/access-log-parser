package ru.kotov.autotests.pobeda;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPagePobeda {

    private WebDriver webDriver;

    @Getter
    @FindBy(css = "#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > a:first-child > img")
    private WebElement logotypeImg;


    public MainPagePobeda(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(this.webDriver, this);
    }

    public String getTitleText() {
        return this.webDriver.getTitle();
    }
}
