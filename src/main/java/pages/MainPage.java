package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;


    private By topOrderButton =
            By.xpath(".//button[@class='Button_Button__ra12g']");

    private By bottomOrderButton =
            By.xpath(".//button[contains(text(),'Заказать')]");



    private By importantQuestion =
            By.id("accordion__heading-0");

    private By importantAnswer =
            By.id("accordion__panel-0");

    private By costQuestion =
            By.id("accordion__heading-1");

    private By costAnswer =
            By.id("accordion__panel-1");

    private By rentTimeQuestion =
            By.id("accordion__heading-2");

    private By rentTimeAnswer =
            By.id("accordion__panel-2");

    private By todayOrderQuestion =
            By.id("accordion__heading-3");

    private By todayOrderAnswer =
            By.id("accordion__panel-3");

    private By extendOrderQuestion =
            By.id("accordion__heading-4");

    private By extendOrderAnswer =
            By.id("accordion__panel-4");

    private By chargerQuestion =
            By.id("accordion__heading-5");

    private By chargerAnswer =
            By.id("accordion__panel-5");

    private By cancelOrderQuestion =
            By.id("accordion__heading-6");

    private By cancelOrderAnswer =
            By.id("accordion__panel-6");

    private By regionQuestion =
            By.id("accordion__heading-7");

    private By regionAnswer =
            By.id("accordion__panel-7");



    public MainPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }



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



    private void scrollToElement(By locator) {

        WebElement element = driver.findElement(locator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);",
                element
        );
    }

    public void openFaq(By question) {

        scrollToElement(question);

        wait.until(ExpectedConditions
                        .elementToBeClickable(question))
                .click();
    }

    public String getAnswer(By answer) {

        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(answer))
                .getText();
    }



    public By getImportantQuestion() { return importantQuestion; }
    public By getImportantAnswer() { return importantAnswer; }

    public By getCostQuestion() { return costQuestion; }
    public By getCostAnswer() { return costAnswer; }

    public By getRentTimeQuestion() { return rentTimeQuestion; }
    public By getRentTimeAnswer() { return rentTimeAnswer; }

    public By getTodayOrderQuestion() { return todayOrderQuestion; }
    public By getTodayOrderAnswer() { return todayOrderAnswer; }

    public By getExtendOrderQuestion() { return extendOrderQuestion; }
    public By getExtendOrderAnswer() { return extendOrderAnswer; }

    public By getChargerQuestion() { return chargerQuestion; }
    public By getChargerAnswer() { return chargerAnswer; }

    public By getCancelOrderQuestion() { return cancelOrderQuestion; }
    public By getCancelOrderAnswer() { return cancelOrderAnswer; }

    public By getRegionQuestion() { return regionQuestion; }
    public By getRegionAnswer() { return regionAnswer; }
}