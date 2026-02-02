package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class FaqTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkFaqAnswerOpens() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickQuestion();
        Assert.assertTrue(mainPage.isAnswerDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
