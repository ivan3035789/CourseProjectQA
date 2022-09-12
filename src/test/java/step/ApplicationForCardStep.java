package step;

import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import screenElements.ApplicationForCardElements;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class ApplicationForCardStep {

    ApplicationForCardElements applicationForCardElements = new ApplicationForCardElements();

    @SneakyThrows
    public void checkLabelText() {
        Allure.step("проверка названия страницы");
        applicationForCardElements.getLabelText().shouldHave(text("Путешествие дня")).shouldBe(visible, Duration.ofSeconds(15));
        Thread.sleep(3000);
    }
    @SneakyThrows
    public void OpeningPages() {
        Allure.step("открытие страницы");
        open("http://localhost:8080");
    }

    @SneakyThrows
    public void checkingTheAppearanceOfTheOperationApprovalLabel() {
        Allure.step("проверка появления надписи об одобрении операции");
        applicationForCardElements.getMessageSuccessfully().shouldHave(text("Успешно")).shouldBe(visible, Duration.ofSeconds(15));
        applicationForCardElements.getMessageOperationIsApprovedByTheBank().shouldHave(text("Операция одобрена Банком.")).shouldBe(visible, Duration.ofSeconds(15));
    }

    @SneakyThrows
    public void checkingTheAppearanceOfTheOperationRefusalLabel() {
        Allure.step("проверка появления надписи об отказе в операции");
        applicationForCardElements.getMessageMistake().shouldHave(text("Ошибка")).shouldBe(visible, Duration.ofSeconds(15));
        applicationForCardElements.getMessageBankRefused().shouldHave(text("Ошибка! Банк отказал в проведении операции.")).shouldBe(visible, Duration.ofSeconds(15));
    }
    @SneakyThrows
    public void clickBuyButton() {
        Allure.step("нажатие на кнопку купить");
        applicationForCardElements.getBuyButton().click();
        Thread.sleep(1000);
    }
    @SneakyThrows
    public void clickContinueButton() {
        Allure.step("нажатие на кнопку продолжить");
        applicationForCardElements.getContinueButton().click();
        Thread.sleep(10000);
    }
    @SneakyThrows
    public void clickingOnTheBuyOnCreditButton() {
        Allure.step("нажатие на кнопку купить в кредит");
        applicationForCardElements.getCreditBuyButton().click();
        Thread.sleep(1000);
    }
    @SneakyThrows
    public void checkingThePageNamePaymentByCard() {
        Allure.step("проверка названия Оплата по карте");
        applicationForCardElements.getInscriptionPaymentByCard().shouldHave(text("Оплата по карте")).shouldHave(visible, Duration.ofSeconds(5));
        Thread.sleep(1000);
    }

    @SneakyThrows
    public void checkingThePageNameCreditAccordingToTheCardData() {
        Allure.step("проверка названия Кредит по данным карты");
        applicationForCardElements.getInscriptionPaymentByCard().shouldHave(text("Кредит по данным карты")).shouldHave(visible, Duration.ofSeconds(5));
        Thread.sleep(1000);
    }
    @SneakyThrows
    public void enteringTheCardNumber(String cardNumber) {
        Allure.step("вводд номера карты");
        applicationForCardElements.getCardNumberInputField().setValue(cardNumber).shouldHave(visible, Duration.ofSeconds(5));
        Thread.sleep(1000);
    }
    @SneakyThrows
    public void enteringTheMonth(String month) {
        Allure.step("вводд месяца");
        applicationForCardElements.getMonthInputField().setValue(month).shouldHave(visible, Duration.ofSeconds(5));
        Thread.sleep(1000);
    }
    @SneakyThrows
    public void enteringTheYear(String year) {
        Allure.step("вводд года");
        applicationForCardElements.getFieldForEnteringTheYear().setValue(year).shouldHave(visible, Duration.ofSeconds(5));
        Thread.sleep(1000);
    }
    @SneakyThrows
    public void enteringTheOwner(String owner) {
        Allure.step("вводд владельца");
        applicationForCardElements.getOwnerInputField().setValue(owner).shouldHave(visible, Duration.ofSeconds(5));
        Thread.sleep(1000);
    }
    @SneakyThrows
    public void enteringCvc(String cvc) {
        Allure.step("вводд cvc");
        applicationForCardElements.getCvcInputField().setValue(cvc).shouldHave(visible, Duration.ofSeconds(5));
        Thread.sleep(1000);
    }

    @SneakyThrows
    public void checkFieldMessage() {
        Allure.step("Проверка появления предупреждающих сообщений");
        applicationForCardElements.getFieldCardNumberMessage().shouldHave(text("Неверный формат")).shouldHave(visible, Duration.ofSeconds(5));
        applicationForCardElements.getFieldMonthMessage().shouldHave(text("Неверный формат")).shouldHave(visible, Duration.ofSeconds(5));
        applicationForCardElements.getFieldYearMessage().shouldHave(text("Неверный формат")).shouldHave(visible, Duration.ofSeconds(5));
        applicationForCardElements.getFieldOwnerMessage().shouldHave(text("Поле обязательно для заполнения")).shouldHave(visible, Duration.ofSeconds(5));
        applicationForCardElements.getFieldCvcMessage().shouldHave(text("Неверный формат")).shouldHave(visible, Duration.ofSeconds(5));
    }
}
