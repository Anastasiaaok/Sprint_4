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


    private By[] questions = {
            By.id("accordion__heading-0"),
            By.id("accordion__heading-1"),
            By.id("accordion__heading-2"),
            By.id("accordion__heading-3"),
            By.id("accordion__heading-4"),
            By.id("accordion__heading-5"),
            By.id("accordion__heading-6"),
            By.id("accordion__heading-7")
    };

    private By[] answers = {
            By.id("accordion__panel-0"),
            By.id("accordion__panel-1"),
            By.id("accordion__panel-2"),
            By.id("accordion__panel-3"),
            By.id("accordion__panel-4"),
            By.id("accordion__panel-5"),
            By.id("accordion__panel-6"),
            By.id("accordion__panel-7")
    };

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

        scrollTo(questions[index]);

        wait.until(ExpectedConditions
                        .elementToBeClickable(questions[index]))
                .click();
    }

    public String getAnswerText(int index) {

        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(answers[index]))
                .getText();
    }
}