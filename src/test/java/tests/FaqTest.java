package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;

@RunWith(Parameterized.class)
public class FaqTest extends BaseTest {

    private final int questionNumber;
    private final String expectedText;

    public FaqTest(int questionNumber, String expectedText) {

        this.questionNumber = questionNumber;
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

        String actualText = "";

        switch (questionNumber) {

            case 0:
                mainPage.openImportantQuestion();
                actualText = mainPage.getImportantAnswer();
                break;

            case 1:
                mainPage.openPriceQuestion();
                actualText = mainPage.getPriceAnswer();
                break;

            case 2:
                mainPage.openRentTimeQuestion();
                actualText = mainPage.getRentTimeAnswer();
                break;

            case 3:
                mainPage.openTodayOrderQuestion();
                actualText = mainPage.getTodayOrderAnswer();
                break;

            case 4:
                mainPage.openExtendOrderQuestion();
                actualText = mainPage.getExtendOrderAnswer();
                break;

            case 5:
                mainPage.openChargerQuestion();
                actualText = mainPage.getChargerAnswer();
                break;

            case 6:
                mainPage.openCancelOrderQuestion();
                actualText = mainPage.getCancelOrderAnswer();
                break;

            case 7:
                mainPage.openRegionQuestion();
                actualText = mainPage.getRegionAnswer();
                break;
        }

        Assert.assertTrue(
                "Ответ не содержит ожидаемый текст",
                actualText.contains(expectedText)
        );
    }
}