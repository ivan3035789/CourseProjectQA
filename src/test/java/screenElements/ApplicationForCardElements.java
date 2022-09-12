package screenElements;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import org.openqa.selenium.support.CacheLookup;

import static com.codeborne.selenide.Selenide.$;

@Data
public class ApplicationForCardElements {
    @CacheLookup
    private final SelenideElement labelText = $("#root > div > h2");
    @CacheLookup
    private SelenideElement inscriptionPaymentByCard = $("#root > div > h3");
    @CacheLookup
    private final SelenideElement buyButton = $("[class=button__content]");
    @CacheLookup
    private final SelenideElement creditBuyButton = $("#root > div > button.button.button_view_extra.button_size_m.button_theme_alfa-on-white > span > span");
    @CacheLookup
    private final SelenideElement continueButton = $("#root > div > form > fieldset > div:nth-child(4) > button");
    @CacheLookup
    private final SelenideElement monthInputField = $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input");
    @CacheLookup
    private final SelenideElement cardNumberInputField = $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__box > input");
    @CacheLookup
    private final SelenideElement fieldForEnteringTheYear = $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input");
    @CacheLookup
    private final SelenideElement ownerInputField = $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input");
    @CacheLookup
    private final SelenideElement cvcInputField = $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__box > input");
    @CacheLookup
    private final SelenideElement InvalidFormat = $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__sub");
    @CacheLookup
    private final SelenideElement TheFieldIsRequiredToFillIn = $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__sub");
    @CacheLookup
    private final SelenideElement messageSuccessfully = $("#root > div > div.notification.notification_status_ok.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white > div.notification__title");
    @CacheLookup
    private final SelenideElement messageOperationIsApprovedByTheBank = $("#root > div > div.notification.notification_status_ok.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white > div.notification__content");
    @CacheLookup
    private final SelenideElement messageMistake = $("#root > div > div.notification.notification_visible.notification_status_error.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white > div.notification__title");
    @CacheLookup
    private final SelenideElement messageBankRefused = $("#root > div > div.notification.notification_status_error.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white > div.notification__content");
    @CacheLookup
    private final SelenideElement messageTheCardExpired = $("#root > div > form > fieldset > div:nth-child(2) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub");
    @CacheLookup
    private final SelenideElement fieldCardNumberMessage = $("#root > div > form > fieldset > div:nth-child(1) > span > span > span.input__sub");
    @CacheLookup
    private final SelenideElement fieldMonthMessage = $("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__sub");
    @CacheLookup
    private final SelenideElement fieldYearMessage = $("#root > div > form > fieldset > div:nth-child(2) > span > span.input-group__input-case.input-group__input-case_invalid > span > span > span.input__sub");
    @CacheLookup
    private final SelenideElement fieldOwnerMessage = $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__sub");
    @CacheLookup
    private final SelenideElement fieldCvcMessage = $("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__sub");

}

