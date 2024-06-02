package ru.kotov.autotests.pobeda;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class MainPagePobedaInfo {
    @Getter
    private SelenideElement informationElement = $("#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-4d364c-root-root > div.dp-12p2oi2-root > a:nth-child(1)");
    private SelenideElement flightPreparationElement = $("#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-n2y4xa-root > div > div > div:nth-child(1) > a");
    private SelenideElement helpfulInformationElement = $("#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-n2y4xa-root > div > div > div:nth-child(2) > a");
    private SelenideElement informationAboutCompanyElement = $("#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > div > div.dp-n2y4xa-root > div > div > div:nth-child(3) > a");



    public SelenideElement getFlightPreparationElement() {
        actions().moveToElement(informationElement).perform();
        return flightPreparationElement;
    }

    public SelenideElement getHelpfulInformationElement() {
        actions().moveToElement(informationElement).perform();
        return helpfulInformationElement;
    }

    public SelenideElement getInformationAboutCompanyElement() {
        actions().moveToElement(informationElement).perform();
        return informationAboutCompanyElement;
    }
}
