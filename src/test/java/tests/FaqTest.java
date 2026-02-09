package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;

@RunWith(Parameterized.class)
public class FaqTest extends BaseTest {

    private final int questionIndex;
    private final String expectedText;


    public FaqTest(int questionIndex, String expectedText) {
        this.questionIndex = questionIndex;
        this.expectedText = expectedText;
    }


    @Parameterized.Parameters(name = "FAQ {0}: проверка ответа")
    public static Object[][] getData() {

        return new Object[][]{

                {
                        0,
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."
                },
                {
                        1,
                        "Пока что у нас так: один заказ — один самокат."
                },
                {
                        2,
                        "Допустим, вы оформляете заказ на 8 мая."
                },
                {
                        3,
                        "Только начиная с завтрашнего дня."
                },
                {
                        4,
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку."
                },
                {
                        5,
                        "Самокат приезжает к вам с полной зарядкой."
                },
                {
                        6,
                        "Нужно сразу позвонить в поддержку."
                },
                {
                        7,
                        "Да, обязательно. Всем самокатов!"
                }
        };
    }


    @Test
    public void faqAnswerTest() {

        MainPage mainPage = new MainPage(driver);

        mainPage.openQuestion(questionIndex);

        String actualText =
                mainPage.getAnswerText(questionIndex);

        Assert.assertEquals(
                "Текст ответа не совпадает",
                expectedText,
                actualText
        );
    }
}
