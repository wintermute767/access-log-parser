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

public class MainPagePobedaInfo {

    private WebDriver webDriver;

    @Getter
    @FindBy(css = "#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-4d364c-root-root > div.dp-12p2oi2-root > a:nth-child(1)")
    private WebElement informationElement;
    @FindBy(css = "#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-n2y4xa-root > div > div > div:nth-child(1) > a")
    private WebElement flightPreparationElement;
    @FindBy(css = "#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-n2y4xa-root > div > div > div:nth-child(2) > a")
    private WebElement helpfulInformationElement;
    @FindBy(css = "#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-n2y4xa-root > div > div > div:nth-child(3) > a")
    private WebElement informationAboutCompanyElement;

    public MainPagePobedaInfo(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(this.webDriver, this);
    }
    public WebElement getFlightPreparationElement() {
        Actions action = new Actions(this.webDriver);
        action.moveToElement(getInformationElement());
        action.perform();
        return flightPreparationElement;
    }

    public WebElement getHelpfulInformationElement() {
        Actions action = new Actions(this.webDriver);
        action.moveToElement(getInformationElement());
        action.perform();
        return helpfulInformationElement;
    }

    public WebElement getInformationAboutCompanyElement() {
        Actions action = new Actions(this.webDriver);
        action.moveToElement(getInformationElement());
        action.perform();
        return informationAboutCompanyElement;
    }
}
