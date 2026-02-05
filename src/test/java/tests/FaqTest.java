package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;

@RunWith(Parameterized.class)
public class FaqTest extends BaseTest {

    private final int index;
    private final String expectedText;

    public FaqTest(int index, String expectedText) {

        this.index = index;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {

        return new Object[][]{

                {0, "400 рублей"},
                {1, "один заказ — один самокат"},
                {2, "8 мая"},
                {3, "завтрашнего дня"},
                {4, "нет"},
                {5, "зарядкой"},
                {6, "не привезли"},
                {7, "обязательно"}
        };
    }

    @Test
    public void checkFaqAnswers() {

        MainPage mainPage = new MainPage(driver);

        mainPage.openQuestion(index);

        String actualText =
                mainPage.getAnswerText(index);

        Assert.assertTrue(
                actualText.contains(expectedText)
        );
    }
}