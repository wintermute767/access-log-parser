package ru.kotov.autotests.testUtils;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;

public class Utils {
    public static SelenideElement checkInputElement(SelenideElement inputElement, String textPlaceholder) {
        return inputElement.shouldBe(visible).shouldHave(attribute("placeholder", textPlaceholder));
    }
    public static SelenideElement checkWithTextElement(SelenideElement inputElement, String textInElement) {
        return inputElement.shouldBe(visible).shouldHave(exactText(textInElement));
    }
}
