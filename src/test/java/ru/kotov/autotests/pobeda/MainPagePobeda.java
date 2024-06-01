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
    private JavascriptExecutor jsExecutor;
    @FindBy(css = "#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > a:first-child > img")
    private WebElement logotypeImg;

    @Getter
    @FindBy(css = "#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-4d364c-root-root > div.dp-12p2oi2-root > a:nth-child(1)")
    private WebElement informationElement;

    @FindBy(css = "#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-n2y4xa-root > div > div > div:nth-child(1) > a")
    private WebElement flightPreparationElement;

    @FindBy(css = "#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-n2y4xa-root > div > div > div:nth-child(2) > a")
    private WebElement helpfulInformationElement;
    @FindBy(css = "#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-n2y4xa-root > div > div > div:nth-child(3) > a")
    private WebElement informationAboutCompanyElement;
    @Getter
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-2iaxa-root > div > div:nth-child(1) > div > div > input")
    private WebElement cityFromElement;
    @Getter
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-2iaxa-root > div > div:nth-child(4) > div > div > input")
    private WebElement cityWhereElement;
    @Getter
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-dqfef5-root > div.dp-9qwv4e-root > div > div:nth-child(1) > div")
    private WebElement dateOfDepartureThereElement;
    @Getter
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-dqfef5-root > div.dp-9qwv4e-root > div > div:nth-child(3) > div")
    private WebElement returnFlightDateElement;
    @Getter
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div > button")
    private WebElement buttonSearchTicket;
    @FindBy(css="#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-2iaxa-root > div > div:nth-child(1) > div.dp-f9qwpd-root-root > div > div.dp-9288i0-wrapper > div.dp-1tlnfet-mask > div > div > div > div > div > button:nth-child(1) > div > div")
    private WebElement firstElementInSearchCityFrom;
    @FindBy(css="#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-2iaxa-root > div > div:nth-child(4) > div.dp-f9qwpd-root-root > div > div.dp-9288i0-wrapper > div.dp-1tlnfet-mask > div > div > div > div > div > button > div > div")
    private WebElement firstElementInSearchCityWhere;
    public MainPagePobeda(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.jsExecutor = (JavascriptExecutor) webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(this.webDriver, this);
    }

    public String getTitleText() {
        return this.webDriver.getTitle();
    }

    public WebElement getLogotypeElement() {
        return logotypeImg;
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

    public void setSiteFromAndWhere(String cityFrom, String cityWhere) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", cityFromElement);
        cityFromElement.click();
        cityFromElement.sendKeys(Keys.CLEAR);
        cityFromElement.sendKeys(cityFrom);
        firstElementInSearchCityFrom.click();
        cityWhereElement.sendKeys(cityWhere);
        firstElementInSearchCityWhere.click();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", buttonSearchTicket);
        buttonSearchTicket.click();
    }
}
