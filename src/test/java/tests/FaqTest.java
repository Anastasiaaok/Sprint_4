package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pages.MainPage;

@RunWith(Parameterized.class)
public class FaqTest extends BaseTest {

    private final By question;
    private final By answer;
    private final String expectedText;

    public FaqTest(By question, By answer, String expectedText) {

        this.question = question;
        this.answer = answer;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {

        return new Object[][]{

                {
                        By.id("accordion__heading-0"),
                        By.id("accordion__panel-0"),
                        "Сутки — 400 рублей"
                },
                {
                        By.id("accordion__heading-1"),
                        By.id("accordion__panel-1"),
                        "один заказ — один самокат"
                },
                {
                        By.id("accordion__heading-2"),
                        By.id("accordion__panel-2"),
                        "на 8 мая"
                },
                {
                        By.id("accordion__heading-3"),
                        By.id("accordion__panel-3"),
                        "начиная с завтрашнего дня"
                },
                {
                        By.id("accordion__heading-4"),
                        By.id("accordion__panel-4"),
                        "Пока что нет"
                },
                {
                        By.id("accordion__heading-5"),
                        By.id("accordion__panel-5"),
                        "с полной зарядкой"
                },
                {
                        By.id("accordion__heading-6"),
                        By.id("accordion__panel-6"),
                        "пока самокат не привезли"
                },
                {
                        By.id("accordion__heading-7"),
                        By.id("accordion__panel-7"),
                        "обязательно"
                }
        };
    }

    @Test
    public void checkFaqAnswers() {

        MainPage mainPage = new MainPage(driver);

        mainPage.openFaq(question);

        String actualText =
                mainPage.getAnswer(answer);

        Assert.assertTrue(
                "Ответ не содержит ожидаемый текст",
                actualText.contains(expectedText)
        );
    }
}