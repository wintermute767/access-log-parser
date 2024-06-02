package ru.kotov.autotests.pobeda;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class MainPagePobeda {

    @Getter
    private SelenideElement logotypeImg = $("#__next > div.dp-lw1vya-root > header > div.dp-rpeswh-root > div > a:first-child > img");


}
