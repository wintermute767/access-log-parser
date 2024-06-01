package ru.kotov.autotests.pobeda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPagePobeda {

    WebDriver webDriver;

    By logotypeImg = By.cssSelector("#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > a:first-child > img");

    By informationElement = By.cssSelector("#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-4d364c-root-root > div.dp-12p2oi2-root > a:nth-child(1)");

    By flightPreparationElement = By.cssSelector("#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-n2y4xa-root > div > div > div:nth-child(1) > a");

    By helpfulInformationElement = By.cssSelector("#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-n2y4xa-root > div > div > div:nth-child(2) > a");

    By informationAboutCompanyElement = By.cssSelector("#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-n2y4xa-root > div > div > div:nth-child(3) > a");
    public MainPagePobeda(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public String getTitleText() {
        return this.webDriver.getTitle();
    }

    public WebElement getLogotypeElement() {
        return this.webDriver.findElement(logotypeImg);
    }

    public WebElement getInformationElement() {
        return this.webDriver.findElement(informationElement);
    }

    public WebElement getFlightPreparationElement() {
        Actions action = new Actions(this.webDriver);
        action.moveToElement(getInformationElement());
        action.perform();
        return this.webDriver.findElement(flightPreparationElement);
    }
    public WebElement getHelpfulInformationElement() {
        Actions action = new Actions(this.webDriver);
        action.moveToElement(getInformationElement());
        action.perform();
        return this.webDriver.findElement(helpfulInformationElement);
    }
    public WebElement getInformationAboutCompanyElement() {
        Actions action = new Actions(this.webDriver);
        action.moveToElement(getInformationElement());
        action.perform();
        return this.webDriver.findElement(informationAboutCompanyElement);
    }
}
