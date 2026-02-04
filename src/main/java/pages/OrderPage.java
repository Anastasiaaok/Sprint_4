package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== ЛОКАТОРЫ =====

    // Первая форма
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");

    // Вторая форма
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentalPeriodField = By.className("Dropdown-control");
    private By rentalPeriodOption = By.xpath(".//div[text()='сутки']");
    private By orderButton = By.xpath(".//button[contains(text(),'Заказать')]");

    // Подтверждение
    private By confirmButton = By.xpath(".//button[text()='Да']");
    private By successPopup = By.className("Order_Modal__YbOVa");

    // ===================

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }

    // Заполнение первой формы
    public void fillFirstForm(String name, String surname, String address, String phone) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroField).sendKeys("Сокольники");
        driver.findElement(phoneField).sendKeys(phone);

        driver.findElement(nextButton).click();
    }

    // Заполнение второй формы и подтверждение
    public void confirmOrder() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(dateField)).sendKeys("10.10.2026");

        driver.findElement(rentalPeriodField).click();
        wait.until(ExpectedConditions
                        .elementToBeClickable(rentalPeriodOption))
                .click();

        driver.findElement(orderButton).click();

        wait.until(ExpectedConditions
                        .elementToBeClickable(confirmButton))
                .click();
    }

    // Проверка успешного создания заказа
    public boolean isOrderCreated() {

        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(successPopup))
                .isDisplayed();
    }
}