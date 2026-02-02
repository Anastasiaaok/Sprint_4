package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    // Кнопки заказа
    private By topOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private By bottomOrderButton = By.xpath(".//button[contains(text(),'Заказать')]");

    // Вопросы FAQ
    private By question1 = By.id("accordion__heading-0");
    private By answer1 = By.id("accordion__panel-0");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }

    public void clickQuestion() {
        driver.findElement(question1).click();
    }

    public boolean isAnswerDisplayed() {
        return driver.findElement(answer1).isDisplayed();
    }
}