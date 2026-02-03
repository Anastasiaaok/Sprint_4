package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Кнопки заказа
    private By topOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");
    private By bottomOrderButton = By.xpath(".//button[contains(text(),'Заказать')]");

    // FAQ
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

    // Клик по кнопке заказа
    public void clickOrderButton(By button) {
        wait.until(ExpectedConditions.elementToBeClickable(button));
        driver.findElement(button).click();
    }

    // Скролл вниз через PAGE_DOWN
    private void scrollDown() {
        driver.findElement(By.tagName("body"))
                .sendKeys(Keys.PAGE_DOWN);
    }

    // Клик по FAQ
    public void clickQuestion(int index) {

        // Прокручиваем несколько раз
        for (int i = 0; i < 5; i++) {
            scrollDown();
        }

        WebElement questionElement =
                wait.until(ExpectedConditions.elementToBeClickable(question(index)));

        questionElement.click();
    }

    // Получаем текст ответа
    public String getAnswerText(int index) {

        WebElement answerElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(answer(index)));

        return answerElement.getText();
    }
}