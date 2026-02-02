package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OrderPage;

@RunWith(Parameterized.class)
public class OrderTest {

    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;

    public OrderTest(String name, String surname, String address, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Анастасия", "Головкина", "Санкт-Петербург", "89999999999"},
                {"Петр", "Петров", "Санкт-Петербург", "88888888888"}
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void orderScooterFromTopButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTopOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillFirstForm(name, surname, address, phone);
        orderPage.confirmOrder();

        Assert.assertTrue(orderPage.isOrderCreated());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}