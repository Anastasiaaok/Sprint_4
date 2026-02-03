package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OrderPage;

@RunWith(Parameterized.class)
public class OrderTest {

    private WebDriver driver;

    private final By orderButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;

    public OrderTest(By orderButton, String name, String surname, String address, String phone) {
        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {By.xpath(".//button[@class='Button_Button__ra12g']"),
                        "Анастасия", "Головкина", "Санкт-Петербург", "89999999999"},

                {By.xpath(".//button[contains(text(),'Заказать')]"),
                        "Петр", "Петров", "Санкт-Петербург", "88888888888"}
        };
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void orderScooterFromBothButtons() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButton(orderButton);

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