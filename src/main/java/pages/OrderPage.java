package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private WebDriver driver;
    private WebDriverWait wait;


    // Первая форма
    private By nameField =
            By.xpath(".//input[@placeholder='* Имя']");

    private By surnameField =
            By.xpath(".//input[@placeholder='* Фамилия']");

    private By addressField =
            By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    private By metroField =
            By.xpath(".//input[@placeholder='* Станция метро']");

    private By phoneField =
            By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    private By nextButton =
            By.xpath(".//button[text()='Далее']");


    // Вторая форма
    private By dateField =
            By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    private By rentField =
            By.className("Dropdown-control");

    private By rentOption =
            By.xpath(".//div[text()='сутки']");


    private By orderButton =
            By.xpath(".//div[contains(@class,'Order_Buttons')]//button[text()='Заказать']");

    private By confirmButton =
            By.xpath(".//button[text()='Да']");


    private By successPopup =
            By.xpath(".//div[contains(@class,'Order_Modal')]//div[contains(text(),'Заказ оформлен')]");


    public OrderPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }


    // Первая форма
    public void fillFirstForm(String name,
                              String surname,
                              String address,
                              String phone) {

        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(nameField))
                .sendKeys(name);

        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);

        // Метро
        driver.findElement(metroField).click();
        driver.findElement(metroField).sendKeys("Сокольники");
        driver.findElement(metroField)
                .sendKeys(Keys.DOWN, Keys.ENTER);

        driver.findElement(phoneField).sendKeys(phone);

        driver.findElement(nextButton).click();
    }


    // Вторая форма + подтверждение
    public void confirmOrder() {

        // Дата
        wait.until(ExpectedConditions
                        .elementToBeClickable(dateField))
                .sendKeys("10.02.2026", Keys.ENTER);

        // Срок аренды
        wait.until(ExpectedConditions
                        .elementToBeClickable(rentField))
                .click();

        wait.until(ExpectedConditions
                        .elementToBeClickable(rentOption))
                .click();


        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                wait.until(ExpectedConditions
                        .visibilityOfElementLocated(orderButton))
        );


        // Подтверждение
        wait.until(ExpectedConditions
                        .elementToBeClickable(confirmButton))
                .click();
    }


    public boolean isOrderCreated() {

        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(successPopup))
                .isDisplayed();
    }
}