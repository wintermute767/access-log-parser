package ru.kotov.autotests.pobeda;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class MainPagePobedaTicketBooking {
    @Getter
    private SelenideElement ticketBookingButtonElement = $("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div.dp-1v2wfuc-root-root-tabs > div.dp-1n9plpp-root-group > button:nth-child(3)");
    @Getter
    private SelenideElement clientLastNameElement = $("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > form > div > div:nth-child(1) > div > div > input");
    @Getter
    private SelenideElement numberTicketElement = $("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > form > div > div:nth-child(2) > div > div > input");
    @Getter
    private SelenideElement searchTicketBookingButtonElement = $("#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > form > div > div.dp-1178lck-root > button");

    @Step("Задание в блоке бронирования фамилии: {lastName} и номера бронирования: {numberTicket}")
    public void setLastNameAndNumberTicket(String lastName, String numberTicket) {
        ticketBookingButtonElement.scrollIntoView(true);
        ticketBookingButtonElement.click();
        clientLastNameElement.setValue(lastName);
        numberTicketElement.setValue(numberTicket);
        searchTicketBookingButtonElement.click();
    }
}
