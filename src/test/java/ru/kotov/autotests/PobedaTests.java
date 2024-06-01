package ru.kotov.autotests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.kotov.autotests.pobeda.MainPagePobeda;

public class PobedaTests {
    WebDriver driver;
    MainPagePobeda mainPagePobeda;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://www.pobeda.aero/");
        driver.manage().deleteAllCookies();
        mainPagePobeda = new MainPagePobeda(this.driver);
    }

    @After
    public void after() {
        driver.quit();
    }


    @Test
    public void test1() {
        Assert.assertEquals(mainPagePobeda.getTitleText(), "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");
        Assert.assertTrue(mainPagePobeda.getLogotypeElement().isDisplayed());

        Assert.assertTrue(mainPagePobeda.getFlightPreparationElement().isDisplayed());
        Assert.assertEquals(mainPagePobeda.getFlightPreparationElement().getText(), "Подготовка к полёту");

        Assert.assertTrue(mainPagePobeda.getHelpfulInformationElement().isDisplayed());
        Assert.assertEquals(mainPagePobeda.getHelpfulInformationElement().getText(), "Полезная информация");

        Assert.assertTrue(mainPagePobeda.getInformationAboutCompanyElement().isDisplayed());
        Assert.assertEquals(mainPagePobeda.getInformationAboutCompanyElement().getText(), "О компании");
    }


}
