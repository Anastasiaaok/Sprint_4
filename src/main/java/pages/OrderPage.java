package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private WebDriver driver;

    private By nameInput = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By metroInput = By.className("select-search__input");
    private By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");

    private By orderButton = By.xpath(".//button[contains(text(),'Заказать')]");
    private By confirmButton = By.xpath(".//button[text()='Да']");
    private By successMessage = By.xpath(".//div[contains(text(),'Заказ оформлен')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstForm(String name, String surname, String address, String phone) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(surnameInput).sendKeys(surname);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(metroInput).click();
        driver.findElement(By.xpath(".//li[1]")).click();
        driver.findElement(phoneInput).sendKeys(phone);
        driver.findElement(nextButton).click();
    }

    public void confirmOrder() {
        driver.findElement(orderButton).click();
        driver.findElement(confirmButton).click();
    }

    public boolean isOrderCreated() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
