package ru.kotov.autotests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import ru.kotov.autotests.pobeda.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static ru.kotov.autotests.testUtils.Utils.checkInputElement;
import static ru.kotov.autotests.testUtils.Utils.checkWithTextElement;

public class PobedaTests {
    MainPagePobeda mainPagePobeda;
    MainPagePobedaInfo mainPagePobedaInfo;
    MainPagePobedaTiketSearch mainPagePobedaTiketSearch;
    MainPagePobedaTicketBooking mainPagePobedaTicketBooking;
    TiketBookingPagePobeda tiketBookingPagePobeda;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        Selenide.open("https://www.pobeda.aero/");
        this.mainPagePobeda = new MainPagePobeda();
        this.mainPagePobedaInfo = new MainPagePobedaInfo();
        this.mainPagePobedaTiketSearch = new MainPagePobedaTiketSearch();
        this.mainPagePobedaTicketBooking = new MainPagePobedaTicketBooking();
        this.tiketBookingPagePobeda = new TiketBookingPagePobeda();
    }


    @Test
    @Order(1)
    public void test1() {
        Assert.assertEquals(title(), "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        mainPagePobeda.getLogotypeImg().shouldBe(visible);
        checkWithTextElement(mainPagePobedaInfo.getFlightPreparationElement(), "Подготовка к полёту");
        checkWithTextElement(mainPagePobedaInfo.getHelpfulInformationElement(), "Полезная информация");
        checkWithTextElement(mainPagePobedaInfo.getInformationAboutCompanyElement(), "О компании");
    }

    @Test
    @Order(2)
    public void test2() {
        SelenideElement cityFromElement = mainPagePobedaTiketSearch.getCityFromElement();

        cityFromElement.shouldBe(visible, Duration.ofSeconds(30));
        cityFromElement.scrollIntoView(true);
        checkInputElement(cityFromElement, "Откуда");
        checkInputElement(mainPagePobedaTiketSearch.getCityWhereElement(), "Куда");

        mainPagePobedaTiketSearch.getDateOfDepartureThereElement().scrollIntoView(true);
        checkInputElement(mainPagePobedaTiketSearch.getDateOfDepartureThereInputElement(), "Туда");
        checkInputElement(mainPagePobedaTiketSearch.getReturnFlightDateInputElement(), "Обратно");
    }


    @Test
    @Order(3)
    public void test3() {
        mainPagePobedaTiketSearch.setSiteFromAndWhere("Москва", "Санкт-Петербург");
        mainPagePobedaTiketSearch.getDateOfDepartureThereElement().shouldHave(attribute("data-errored", "true"));
    }

    @Test
    @Order(4)
    public void test4() {
        SelenideElement ticketBookingButtonElement = mainPagePobedaTicketBooking.getTicketBookingButtonElement();
        ticketBookingButtonElement.scrollIntoView(true);
        ticketBookingButtonElement.shouldBe(visible, Duration.ofSeconds(10));
        ticketBookingButtonElement.click();

        SelenideElement clientLastNameElement = mainPagePobedaTicketBooking.getClientLastNameElement();
        clientLastNameElement.scrollIntoView(true);
        checkInputElement(clientLastNameElement, "Фамилия клиента");

        SelenideElement numberTicketElement = mainPagePobedaTicketBooking.getNumberTicketElement();
        numberTicketElement.scrollIntoView(true);
        checkInputElement(numberTicketElement, "Номер бронирования или билета");

        SelenideElement searchTicketBookingButtonElement = mainPagePobedaTicketBooking.getSearchTicketBookingButtonElement();
        searchTicketBookingButtonElement.scrollIntoView(true);
        searchTicketBookingButtonElement.shouldBe(visible).shouldHave(exactText("ПОИСК"));
    }

    @Test
    @Order(5)
    @SneakyThrows
    public void test5() {
        mainPagePobedaTicketBooking.setLastNameAndNumberTicket("Qwerty", "123456");
        switchTo().window(1);

        SelenideElement iNotRobotJSButton = tiketBookingPagePobeda.getINotRobotJSButton();
        if (iNotRobotJSButton.exists()) {
            iNotRobotJSButton.shouldBe(clickable, Duration.ofSeconds(10));
            iNotRobotJSButton.click();
        }

        SelenideElement errorMessageElement = tiketBookingPagePobeda.getErrorMessageElement();
        errorMessageElement.shouldBe(visible, Duration.ofMinutes(2));
        Assert.assertEquals(errorMessageElement.getText(), "Заказ с указанными параметрами не найден");
        switchTo().window(0);
    }
}
