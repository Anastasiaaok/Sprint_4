package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ===== КНОПКИ ЗАКАЗА =====

    private By topOrderButton =
            By.xpath(".//button[@class='Button_Button__ra12g']");

    private By bottomOrderButton =
            By.xpath(".//button[contains(text(),'Заказать')]");


    // ===== FAQ ВОПРОСЫ =====

    private By importantQuestion =
            By.id("accordion__heading-0");

    private By priceQuestion =
            By.id("accordion__heading-1");

    private By rentTimeQuestion =
            By.id("accordion__heading-2");

    private By todayOrderQuestion =
            By.id("accordion__heading-3");

    private By extendOrderQuestion =
            By.id("accordion__heading-4");

    private By chargerQuestion =
            By.id("accordion__heading-5");

    private By cancelOrderQuestion =
            By.id("accordion__heading-6");

    private By regionQuestion =
            By.id("accordion__heading-7");


    // ===== FAQ ОТВЕТЫ =====

    private By importantAnswer =
            By.id("accordion__panel-0");

    private By priceAnswer =
            By.id("accordion__panel-1");

    private By rentTimeAnswer =
            By.id("accordion__panel-2");

    private By todayOrderAnswer =
            By.id("accordion__panel-3");

    private By extendOrderAnswer =
            By.id("accordion__panel-4");

    private By chargerAnswer =
            By.id("accordion__panel-5");

    private By cancelOrderAnswer =
            By.id("accordion__panel-6");

    private By regionAnswer =
            By.id("accordion__panel-7");


    public MainPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }


    // ===== ЗАКАЗ =====

    public void clickOrderButton(boolean isTop) {

        if (isTop) {
            wait.until(ExpectedConditions
                            .elementToBeClickable(topOrderButton))
                    .click();
        } else {
            wait.until(ExpectedConditions
                            .elementToBeClickable(bottomOrderButton))
                    .click();
        }
    }


    // ===== FAQ =====

    private void scrollTo(By locator) {

        WebElement element = driver.findElement(locator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);",
                element
        );
    }


    public void openImportantQuestion() {
        openQuestion(importantQuestion);
    }

    public void openPriceQuestion() {
        openQuestion(priceQuestion);
    }

    public void openRentTimeQuestion() {
        openQuestion(rentTimeQuestion);
    }

    public void openTodayOrderQuestion() {
        openQuestion(todayOrderQuestion);
    }

    public void openExtendOrderQuestion() {
        openQuestion(extendOrderQuestion);
    }

    public void openChargerQuestion() {
        openQuestion(chargerQuestion);
    }

    public void openCancelOrderQuestion() {
        openQuestion(cancelOrderQuestion);
    }

    public void openRegionQuestion() {
        openQuestion(regionQuestion);
    }


    private void openQuestion(By question) {

        scrollTo(question);

        wait.until(ExpectedConditions
                        .elementToBeClickable(question))
                .click();
    }


    public String getImportantAnswer() {
        return getAnswer(importantAnswer);
    }

    public String getPriceAnswer() {
        return getAnswer(priceAnswer);
    }

    public String getRentTimeAnswer() {
        return getAnswer(rentTimeAnswer);
    }

    public String getTodayOrderAnswer() {
        return getAnswer(todayOrderAnswer);
    }

    public String getExtendOrderAnswer() {
        return getAnswer(extendOrderAnswer);
    }

    public String getChargerAnswer() {
        return getAnswer(chargerAnswer);
    }


    public String getCancelOrderAnswer() {
        return getAnswer(cancelOrderAnswer);
    }

    public String getRegionAnswer() {
        return getAnswer(regionAnswer);
    }


    private String getAnswer(By answer) {

        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(answer))
                .getText();
    }
}