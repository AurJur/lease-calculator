package lt.vln.tyz.leasecalculatortests.po.leasecalc;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LeaseCalculatorInputsPo {

    private final WebDriver dr;
    private final String MAIN_FRAME_ID = "calculator-frame-06";
    private final String PURCHASE_VALUE_INPUT = "input[id='f-summa']";
    private final String PURCHASE_VALUE_ERROR = "label[id='f-summa-error']";
    private final String INTEREST_RATE_INPUT = "input[id='f-likme']";
    private final String INTEREST_RATE_ERROR = "label[id='f-likme-error']";
    private final String PAYMENT_TERM_SELECTOR = "select[id='f-termins']";
    private final String FIRST_INSTALLMENT_INPUT = "input[id='f-maksa']";
    private final String FIRST_INSTALLMENT_ERROR = "label[id='f-maksa-error']";
    private final String FIRST_INSTALLMENT_SELECTOR = "select[id='f-maksa-type']";
    private final String REMAINING_VALUE_INPUT = "input[id='f-rest']";
    private final String REMAINING_VALUE_ERROR = "label[id='f-rest-error']";
    private final String SUBMIT_BUTTON = "button[type='submit']";

    public LeaseCalculatorInputsPo(WebDriver dr) {
        this.dr = dr;
    }

    public void switchTo() {
        dr.switchTo().frame(MAIN_FRAME_ID);
    }

    // purchase value
    public WebElement purchaseValueInput() {
        return dr.findElement(By.cssSelector(PURCHASE_VALUE_INPUT));
    }

    public void enterPurchaseValue(String amount) {
        purchaseValueInput().clear();
        purchaseValueInput().sendKeys(amount);
    }

    public WebElement purchaseValueError() {
        return dr.findElement(By.cssSelector(PURCHASE_VALUE_ERROR));
    }

    public String getPurchaseValueError() {
        return purchaseValueError().getText();
    }

    // interest rate
    public WebElement interestRateInput() {
        return dr.findElement(By.cssSelector(INTEREST_RATE_INPUT));
    }

    public void enterInterestRate(String rate) {
        interestRateInput().clear();
        interestRateInput().sendKeys(rate);
    }

    public WebElement interestRateError() {
        try {
            return dr.findElement(By.cssSelector(INTEREST_RATE_ERROR));
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public String getInterestRateError() {
        if (interestRateError() != null) {
            return interestRateError().getText();
        } else {
            return "";
        }
    }

    // payment term
    public Select paymentTermSelector() {
        return new Select(dr.findElement(By.cssSelector(PAYMENT_TERM_SELECTOR)));
    }

    public void selectPaymentTerm(String months) {
        paymentTermSelector().selectByValue(months);
    }

    // first installment
    public WebElement firstInstallmentInput() {
        return dr.findElement(By.cssSelector(FIRST_INSTALLMENT_INPUT));
    }

    public void enterFirstInstallment(String value) {
        firstInstallmentInput().clear();
        firstInstallmentInput().sendKeys(value);
    }

    public WebElement firstInstallmentError() {
        return dr.findElement(By.cssSelector(FIRST_INSTALLMENT_ERROR));
    }

    public String getFirstInstallmentError() {
        return firstInstallmentError().getText();
    }

    public Select firstInstallmentSelector() {
        return new Select(dr.findElement(By.cssSelector(FIRST_INSTALLMENT_SELECTOR)));
    }

    public void selectEurForFirstInstallment(String visibleText) {
        firstInstallmentSelector().selectByVisibleText(visibleText);
    }

    // remaining value
    public WebElement remainingValueInput() {
        return dr.findElement(By.cssSelector(REMAINING_VALUE_INPUT));
    }

    public void enterRemainingValue(String value) {
        remainingValueInput().clear();
        remainingValueInput().sendKeys(value);
    }

    public WebElement remainingValueError() {
        return dr.findElement(By.cssSelector(REMAINING_VALUE_ERROR));
    }

    public String getRemainingValueError() {
        return remainingValueError().getText();
    }

    // submit
    public WebElement submitButton() {
        return dr.findElement(By.cssSelector(SUBMIT_BUTTON));
    }

    public void clickCalculate() {
        submitButton().click();
    }
}
