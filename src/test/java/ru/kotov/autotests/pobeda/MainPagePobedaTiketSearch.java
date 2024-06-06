package ru.kotov.autotests.pobeda;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SetValueOptions;
import com.codeborne.selenide.commands.Clear;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class MainPagePobedaTiketSearch {
    @Getter
    private SelenideElement cityFromElement = $("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-2iaxa-root > div > div:nth-child(1) > div > div > input");
    @Getter
    private SelenideElement cityWhereElement = $("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-2iaxa-root > div > div:nth-child(4) > div > div > input");
    @Getter
    private SelenideElement dateOfDepartureThereElement = $("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-dqfef5-root > div.dp-9qwv4e-root > div.dp-m5wmd7-root-root > div:nth-child(1) > div");
    @Getter
    private SelenideElement dateOfDepartureThereInputElement = $("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-dqfef5-root > div.dp-9qwv4e-root > div.dp-m5wmd7-root-root > div:nth-child(1) > div > input");
    @Getter
    private SelenideElement returnFlightDateInputElement = $("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-dqfef5-root > div.dp-9qwv4e-root > div.dp-m5wmd7-root-root > div:nth-child(3) > div > input");
    @Getter
    private SelenideElement buttonSearchTicket = $("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div > button");
    @Getter
    private SelenideElement firstElementInSearchCityFrom = $("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-2iaxa-root > div > div:nth-child(1) > div.dp-f9qwpd-root-root > div > div.dp-9288i0-wrapper > div.dp-1tlnfet-mask > div > div > div > div > div > button:nth-child(1) > div > div");
    @Getter
    private SelenideElement firstElementInSearchCityWhere = $("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > div:nth-child(3) > form > div > div.dp-1hfe4jj-root > div > div.dp-2iaxa-root > div > div:nth-child(4) > div.dp-f9qwpd-root-root > div > div.dp-9288i0-wrapper > div.dp-1tlnfet-mask > div > div > div > div > div > button > div > div");
    @Step("Задание в блоке поиска билета города откуда: {cityFrom}, и куда: {cityWhere}")
    public void setSiteFromAndWhere(String cityFrom, String cityWhere) {
        cityFromElement.shouldBe(visible,Duration.ofSeconds(10));
        cityFromElement.scrollIntoView(true);
        if(!cityFromElement.is(attribute("value",cityFrom))){
            cityFromElement.click();
            firstElementInSearchCityFrom.scrollIntoView(true);
            firstElementInSearchCityFrom.shouldBe(visible, Duration.ofSeconds(5));
            cityFromElement.sendKeys(Keys.CLEAR);
            cityFromElement.setValue(cityFrom);
            firstElementInSearchCityFrom.shouldBe(clickable,Duration.ofSeconds(10));
            firstElementInSearchCityFrom.click();
        }
        cityWhereElement.setValue(cityWhere);
        firstElementInSearchCityWhere.scrollIntoView(true);
        firstElementInSearchCityWhere.shouldBe(clickable,Duration.ofSeconds(10));
        firstElementInSearchCityWhere.click();
        buttonSearchTicket.scrollIntoView(true);
        buttonSearchTicket.click();
        buttonSearchTicket.click();
    }
}
