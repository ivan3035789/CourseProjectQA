package test;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.Helper;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import step.ApplicationForCardStep;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static data.Helper.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApplicationForCardTest {

    ApplicationForCardStep applicationForCardStep = new ApplicationForCardStep();

    String validCardApproved = validCardApproved();
    String validCardDeclined = validCardDeclined();
    String invalidCard = invalidCard();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        truncateTables();
    }

    @BeforeEach
    public void setUpAll() {
        applicationForCardStep.OpeningPages();
    }

    @AfterEach
    public void timeOut() {
        clearBrowserCookies();
        closeWebDriver();
    }

    @Order(1)
    @Description("В этом тест-кейсе мы проверяем успешную оплату картой APPROVED")
    @DisplayName("must buy tour of Approved")
    @Test
    public void mustBuyTourOfApproved() {
        applicationForCardStep.checkLabelText();
        applicationForCardStep.clickBuyButton();
        applicationForCardStep.checkingThePageNamePaymentByCard();
        applicationForCardStep.enteringTheCardNumber(validCardApproved);
        applicationForCardStep.enteringTheMonth(validMonth());
        applicationForCardStep.enteringTheYear(validYear());
        applicationForCardStep.enteringTheOwner(validOwner());
        applicationForCardStep.enteringCvc(validCvc());
        applicationForCardStep.clickContinueButton();
        applicationForCardStep.checkingTheAppearanceOfTheOperationApprovalLabel();
        String status = Helper.userStatus(validCardApproved);
        assertEquals("APPROVED", status);
    }

    @Order(2) //падает в базе создается непонятно через какое время лтбо что то происходит что не дает вытащить данные
    @Description("В этом тест-кейсе мы проверяем успешную оплату картой DECLINED")
    @DisplayName("must buy tour of Declined")
    @Test
    public void mustBuyTourOfDeclined() {
        applicationForCardStep.checkLabelText();
        applicationForCardStep.clickBuyButton();
        applicationForCardStep.checkingThePageNamePaymentByCard();
        applicationForCardStep.enteringTheCardNumber(validCardDeclined);
        applicationForCardStep.enteringTheMonth(validMonth());
        applicationForCardStep.enteringTheYear(validYear());
        applicationForCardStep.enteringTheOwner(validOwner());
        applicationForCardStep.enteringCvc(validCvc());
        applicationForCardStep.clickContinueButton();
        applicationForCardStep.checkingTheAppearanceOfTheOperationApprovalLabel();
        String status = Helper.userStatus(validCardDeclined);
        assertEquals("DECLINED", status);
    }

    @Order(3) //падает в базе создается непонятно через какое время лтбо что то происходит что не дает вытащить данные
    @Description("В этом тест-кейсе мы проверяем успешную оплату картой APPROVED в кредит")
    @DisplayName("must buy tour on credit of Approved")
    @Test
    public void mustBuyTourOnCreditOfApproved() {
        applicationForCardStep.checkLabelText();
        applicationForCardStep.clickingOnTheBuyOnCreditButton();
        applicationForCardStep.checkingThePageNameCreditAccordingToTheCardData();
        applicationForCardStep.enteringTheCardNumber(validCardApproved);
        applicationForCardStep.enteringTheMonth(validMonth());
        applicationForCardStep.enteringTheYear(validYear());
        applicationForCardStep.enteringTheOwner(validOwner());
        applicationForCardStep.enteringCvc(validCvc());
        applicationForCardStep.clickContinueButton();
        applicationForCardStep.checkingTheAppearanceOfTheOperationApprovalLabel();
        String status = Helper.userStatus(validCardApproved);
        assertEquals("APPROVED", status);
    }

    @Order(4)
    @Description("В этом тест-кейсе мы проверяем успешную оплату картой DECLINED в кредит")
    @DisplayName("must buy tour on credit of Declined")
    @Test
    public void mustBuyTourOnCreditOfDeclined() {
        applicationForCardStep.checkLabelText();
        applicationForCardStep.clickingOnTheBuyOnCreditButton();
        applicationForCardStep.checkingThePageNameCreditAccordingToTheCardData();
        applicationForCardStep.enteringTheCardNumber(validCardDeclined);
        applicationForCardStep.enteringTheMonth(validMonth());
        applicationForCardStep.enteringTheYear(validYear());
        applicationForCardStep.enteringTheOwner(validOwner());
        applicationForCardStep.enteringCvc(validCvc());
        applicationForCardStep.clickContinueButton();
        applicationForCardStep.checkingTheAppearanceOfTheOperationApprovalLabel();
        String status = Helper.userStatus(validCardDeclined);
        assertEquals("DECLINED", status);
    }

    @Order(5)
    @Description("В этом тест-кейсе мы проверяем отказ в оплате невалидной картой в кредит")
    @DisplayName("must buy tour on credit of invalid card")
    @Test
    public void mustBuyTourOnCreditOfInvalidCard() {
        applicationForCardStep.checkLabelText();
        applicationForCardStep.clickingOnTheBuyOnCreditButton();
        applicationForCardStep.checkingThePageNameCreditAccordingToTheCardData();
        applicationForCardStep.enteringTheCardNumber(invalidCard);
        applicationForCardStep.enteringTheMonth(validMonth());
        applicationForCardStep.enteringTheYear(validYear());
        applicationForCardStep.enteringTheOwner(validOwner());
        applicationForCardStep.enteringCvc(validCvc());
        applicationForCardStep.clickContinueButton();
        applicationForCardStep.checkingTheAppearanceOfTheOperationRefusalLabel();
    }

    @Order(6)
    @Description("В этом тест-кейсе мы проверяем отказ в оплате невалидной картой")
    @DisplayName("must buy tour of invalid card")
    @Test
    public void mustBuyTourOfInvalidCard() {
        applicationForCardStep.checkLabelText();
        applicationForCardStep.clickBuyButton();
        applicationForCardStep.checkingThePageNamePaymentByCard();
        applicationForCardStep.enteringTheCardNumber(invalidCard);
        applicationForCardStep.enteringTheMonth(validMonth());
        applicationForCardStep.enteringTheYear(validYear());
        applicationForCardStep.enteringTheOwner(validOwner());
        applicationForCardStep.enteringCvc(validCvc());
        applicationForCardStep.clickContinueButton();
        applicationForCardStep.checkingTheAppearanceOfTheOperationRefusalLabel();
    }

    @Order(6)
    @Description("В этом тест-кейсе мы проверяем появление предупреждающих сообщениях при незаполненных полях")
    @DisplayName("a warning message should appear")
    @Test
    public void warningMessageShouldAppear() {
        applicationForCardStep.checkLabelText();
        applicationForCardStep.clickBuyButton();
        applicationForCardStep.checkingThePageNamePaymentByCard();
//        applicationForCardStep.enteringTheCardNumber(invalidCard);
//        applicationForCardStep.enteringTheMonth(invalidMonth());
//        applicationForCardStep.enteringTheYear(invalidYear());
//        applicationForCardStep.enteringTheOwner(invalidOwner());
//        applicationForCardStep.enteringCvc(invalidCvc());
        applicationForCardStep.clickContinueButton();
        applicationForCardStep.checkFieldMessage();
//доделать
    }
}
