package ru.kotov.autotests.pobeda;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TiketBookingPagePobeda {

    private WebDriver webDriver;

    @Getter
    @FindBy(/*css = "body > div.app-container > section > div.content > div > div > div.message_error",*/
            xpath = "/html/body/div[1]/section/div[1]/div/div/div[2]")
    private WebElement errorMessageElement;
    @Getter
    @FindBy(css = "#js-button")
    private WebElement iNotRobotJSButton;


    public TiketBookingPagePobeda(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        this.webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        PageFactory.initElements(this.webDriver, this);
    }

    public void bypassСaptcha() {
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(getErrorMessageElement())).click();
    }
    public String getTitleText() {
        return this.webDriver.getTitle();
    }
}
