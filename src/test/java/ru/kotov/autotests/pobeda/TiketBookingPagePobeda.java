package ru.kotov.autotests.pobeda;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class TiketBookingPagePobeda {
    @Getter
    private SelenideElement errorMessageElement = $("body > div.app-container > section > div.content > div > div > div.message_error");
    @Getter
    private SelenideElement iNotRobotJSButton = $("#js-button");

}
