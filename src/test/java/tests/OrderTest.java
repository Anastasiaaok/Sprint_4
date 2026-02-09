package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;
import pages.OrderPage;


@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final boolean isTopButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;

    public OrderTest(boolean isTopButton,
                     String name,
                     String surname,
                     String address,
                     String phone) {

        this.isTopButton = isTopButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {

        return new Object[][]{

                {true, "Анастасия", "Головкина", "Санкт-Петербург", "89990000000"},
                {false, "Петр", "Петров", "Москва", "88880000000"}
        };
    }

    @Test
    public void orderScooterTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage.clickOrderButton(isTopButton);

        OrderPage orderPage = new OrderPage(driver);

        orderPage.fillFirstForm(
                name,
                surname,
                address,
                phone
        );

        orderPage.confirmOrder();

        Assert.assertTrue(
                orderPage.isOrderCreated()
        );
    }
}