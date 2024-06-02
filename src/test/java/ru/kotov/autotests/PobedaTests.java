package ru.kotov.autotests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kotov.autotests.pobeda.*;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class PobedaTests {
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    MainPagePobeda mainPagePobeda;
    MainPagePobedaInfo mainPagePobedaInfo;
    MainPagePobedaTiketSearch mainPagePobedaTiketSearch;
    MainPagePobedaTicketBooking mainPagePobedaTicketBooking;
    TiketBookingPagePobeda tiketBookingPagePobeda;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://www.pobeda.aero/");
        this.driver.manage().deleteAllCookies();
        this.jsExecutor = (JavascriptExecutor) this.driver;
        this.mainPagePobeda = new MainPagePobeda(this.driver);
        this.mainPagePobedaInfo = new MainPagePobedaInfo(this.driver);
        this.mainPagePobedaTiketSearch = new MainPagePobedaTiketSearch(this.driver);
        this.mainPagePobedaTicketBooking = new MainPagePobedaTicketBooking(this.driver);
        this.tiketBookingPagePobeda = new TiketBookingPagePobeda(this.driver);
    }

    @After
    public void after() {
        driver.quit();
    }


    @Test
    public void test1() {
        Assert.assertEquals(mainPagePobeda.getTitleText(), "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        Assert.assertTrue(mainPagePobeda.getLogotypeImg().isDisplayed());

        WebElement flightPreparationElement = mainPagePobedaInfo.getFlightPreparationElement();
        Assert.assertTrue(flightPreparationElement.isDisplayed());
        Assert.assertEquals(flightPreparationElement.getText(), "Подготовка к полёту");

        WebElement helpfulInformationElement = mainPagePobedaInfo.getHelpfulInformationElement();
        Assert.assertTrue(helpfulInformationElement.isDisplayed());
        Assert.assertEquals(helpfulInformationElement.getText(), "Полезная информация");

        WebElement informationAboutCompanyElement = mainPagePobedaInfo.getInformationAboutCompanyElement();
        Assert.assertTrue(informationAboutCompanyElement.isDisplayed());
        Assert.assertEquals(informationAboutCompanyElement.getText(), "О компании");
    }

    @Test
    public void test2() {
        Assert.assertTrue(mainPagePobedaTiketSearch.getCityFromElement().isDisplayed());
        Assert.assertTrue(mainPagePobedaTiketSearch.getCityWhereElement().isDisplayed());
        Assert.assertTrue(mainPagePobedaTiketSearch.getDateOfDepartureThereElement().isDisplayed());
        Assert.assertTrue(mainPagePobedaTiketSearch.getReturnFlightDateElement().isDisplayed());
    }
    @Test
    public void test3() {
        mainPagePobedaTiketSearch.setSiteFromAndWhere("Москва","Санкт-Петербург");
        Assert.assertEquals(mainPagePobedaTiketSearch.getDateOfDepartureThereElement().getAttribute("data-errored"), "true");
    }

    @Test
    public void test4() {
        WebElement ticketBookingButtonElement = mainPagePobedaTicketBooking.getTicketBookingButtonElement();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", ticketBookingButtonElement);
        ticketBookingButtonElement.click();

        WebElement clientLastNameElement = mainPagePobedaTicketBooking.getClientLastNameElement();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", clientLastNameElement);
        Assert.assertTrue(clientLastNameElement.isDisplayed());
        Assert.assertEquals(clientLastNameElement.getAttribute("placeholder"),"Фамилия клиента");

        WebElement numberTicketElement = mainPagePobedaTicketBooking.getNumberTicketElement();
        Assert.assertTrue(numberTicketElement.isDisplayed());
        Assert.assertEquals(numberTicketElement.getAttribute("placeholder"),"Номер бронирования или билета");

        WebElement searchTicketBookingButtonElement = mainPagePobedaTicketBooking.getSearchTicketBookingButtonElement();
        Assert.assertTrue(searchTicketBookingButtonElement.isDisplayed());
        Assert.assertEquals(searchTicketBookingButtonElement.getText(),"ПОИСК");
    }
    @Test

    public void test5() {
        String originalWindow = driver.getWindowHandle();
        mainPagePobedaTicketBooking.setLastNameAndNumberTicket("Qwerty","123456");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        tiketBookingPagePobeda.bypassСaptcha();
        Assert.assertEquals(tiketBookingPagePobeda.getErrorMessageElement().getText(), "Заказ с указанными параметрами не найден");
        driver.switchTo().window(originalWindow);
    }
}
