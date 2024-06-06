package ru.kotov.autotests.testUtils;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

public class Utils {
    @Step("Проверка что элемент ввода отображается и имеет текстовое обозначение: {textInElement}")
    public static SelenideElement checkInputElement(SelenideElement inputElement, String textPlaceholder) {
        return inputElement.shouldBe(visible).shouldHave(attribute("placeholder", textPlaceholder));
    }
    @Step("Проверка что текстовый элемент отображается и имеет текстовое обозначение: {textInElement}")
    public static SelenideElement checkWithTextElement(SelenideElement inputElement, String textInElement) {
        return inputElement.shouldBe(visible).shouldHave(exactText(textInElement));
    }
}
