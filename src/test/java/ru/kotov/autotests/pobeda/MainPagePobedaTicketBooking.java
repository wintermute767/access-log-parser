package ru.kotov.autotests.pobeda;

import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class MainPagePobedaTicketBooking {

    private WebDriver webDriver;

    @Getter
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div.dp-1v2wfuc-root-root-tabs > div.dp-1n9plpp-root-group > button:nth-child(3)")
    private WebElement ticketBookingButtonElement;
    @Getter
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > form > div > div:nth-child(1) > div > div > input")
    private WebElement clientLastNameElement;
    @Getter
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > form > div > div:nth-child(2) > div > div > input")
    private WebElement numberTicketElement;
    @Getter
    @FindBy(css = "#__next > div.dp-lw1vya-root > main > div > div > div.dp-1xty3kd-root-container > div > div:nth-child(3) > form > div > div.dp-1178lck-root > button")
    private WebElement searchTicketBookingButtonElement;


    public MainPagePobedaTicketBooking(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        this.webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(this.webDriver, this);
    }

    @SneakyThrows
    public void setLastNameAndNumberTicket(String lastName, String numberTicket) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ticketBookingButtonElement);
        ticketBookingButtonElement.click();
        clientLastNameElement.sendKeys(lastName);
        numberTicketElement.sendKeys(numberTicket);
        searchTicketBookingButtonElement.click();


    }
}
