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



    private By question(int index) {
        return By.id("accordion__heading-" + index);
    }

    private By answer(int index) {
        return By.id("accordion__panel-" + index);
    }


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



    private void scrollTo(By locator) {

        WebElement element = driver.findElement(locator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView(true);",
                element
        );
    }


    public void openQuestion(int index) {

        By question = question(index);

        scrollTo(question);

        wait.until(ExpectedConditions
                        .elementToBeClickable(question))
                .click();
    }


    public String getAnswerText(int index) {

        By answer = answer(index);

        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(answer))
                .getText();
    }
}
