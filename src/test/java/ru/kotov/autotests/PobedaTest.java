package ru.kotov.autotests;

import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;


import io.qameta.allure.Feature;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import ru.kotov.autotests.pobeda.*;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static ru.kotov.autotests.testUtils.Utils.checkInputElement;
import static ru.kotov.autotests.testUtils.Utils.checkWithTextElement;

@Epic("Pobeda")
public class PobedaTest {
    MainPagePobeda mainPagePobeda= new MainPagePobeda();
    MainPagePobedaInfo mainPagePobedaInfo= new MainPagePobedaInfo();
    MainPagePobedaTiketSearch mainPagePobedaTiketSearch = new MainPagePobedaTiketSearch();
    MainPagePobedaTicketBooking mainPagePobedaTicketBooking= new MainPagePobedaTicketBooking();
    TiketBookingPagePobeda tiketBookingPagePobeda = new TiketBookingPagePobeda();

    @BeforeAll
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("https://www.pobeda.aero/");
    }


    @Test
    @Order(1)
    @Description(value = "Тест заглавное страницы: наличие заголовка и ссылок \"Подготовка к полёту\",\"Полезная информация\",\"О компании\"")
    @Feature("Главная страница")
    public void test1() {
        Assertions.assertEquals(title(), "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        mainPagePobeda.getLogotypeImg().shouldBe(visible);
        checkWithTextElement(mainPagePobedaInfo.getFlightPreparationElement(), "Подготовка к полёту");
        checkWithTextElement(mainPagePobedaInfo.getHelpfulInformationElement(), "Полезная информация");
        checkWithTextElement(mainPagePobedaInfo.getInformationAboutCompanyElement(), "О компании");
    }

    @Test
    @Order(2)
    @Feature("Блок Поиска билета")
    @Description(value = "Тест блока Поиска билета на наличие всех обязательных элементов")
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
    @Feature("Блок Поиска билета")
    @Description(value = "Тест блока Поиск билета без выбора задания конкретной даты")
    public void test3() {
        mainPagePobedaTiketSearch.setSiteFromAndWhere("Москва", "Санкт-Петербург");
        mainPagePobedaTiketSearch.getDateOfDepartureThereElement().shouldHave(attribute("data-errored", "true"));
    }

    @Test
    @Order(4)
    @Feature("Блок Управление бронированием")
    @Description(value = "Тест в блоке Управление бронированием на наличие всех обязательных элементов")
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
    @Feature("Блок Управление бронированием")
    @Description(value = "Тест блока Управление бронированием с указанием не существующей брони (заранее провальный)")
    public void test5() {
        mainPagePobedaTicketBooking.setLastNameAndNumberTicket("Qwerty", "123456");
//        switchTo().window(1);

//        SelenideElement iNotRobotJSButton = tiketBookingPagePobeda.getINotRobotJSButton();
//        if (iNotRobotJSButton.exists()) {
//            iNotRobotJSButton.shouldBe(clickable, Duration.ofSeconds(10));
//            iNotRobotJSButton.click();
//        }
//
        SelenideElement errorMessageElement = tiketBookingPagePobeda.getErrorMessageElement();
//        errorMessageElement.shouldBe(visible, Duration.ofMinutes(2));
        Assertions.assertEquals(errorMessageElement.getText(), "Заказ с указанными параметрами не найден");
        switchTo().window(0);
    }
}
