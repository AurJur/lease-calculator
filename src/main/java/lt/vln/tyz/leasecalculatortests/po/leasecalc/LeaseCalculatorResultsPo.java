package lt.vln.tyz.leasecalculatortests.po.leasecalc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeaseCalculatorResultsPo {

    private final WebDriver dr;
    private final String MAIN_FRAME_ID = "calculator-frame-06";
    private final String MONTHLY_PAYMENT_VALUE = "span[data-name='monthly_payment']";
    private final String COMMISSION_FEE_VALUE = "span[data-name='commision']";
    private final String FIRST_INSTALLMENT_VALUE = "span[data-name='maksa']";

    public LeaseCalculatorResultsPo(WebDriver dr) {
        this.dr = dr;
    }

    public void switchTo() {
        dr.switchTo().frame(MAIN_FRAME_ID);
    }

    public WebElement monthlyPaymentValue() {
        return dr.findElement(By.cssSelector(MONTHLY_PAYMENT_VALUE));
    }

    public String getMonthlyPaymentValue() {
        return monthlyPaymentValue().getText();
    }

    public WebElement monthlyPaymentCurrency() {
        return getCurrencyWebEl(monthlyPaymentValue());
    }

    public String getMonthlyPaymentCurrency() {
        return monthlyPaymentCurrency().getText();
    }

    public WebElement commissionFeeValue() {
        return dr.findElement(By.cssSelector(COMMISSION_FEE_VALUE));
    }

    public String getCommissionFeeValue() {
        return commissionFeeValue().getText();
    }

    public WebElement commissionFeeCurrency() {
        return getCurrencyWebEl(commissionFeeValue());
    }

    public String getCommissionFeeCurrency() {
        return commissionFeeCurrency().getText();
    }

    public WebElement firstInstallmentValue() {
        return dr.findElement(By.cssSelector(FIRST_INSTALLMENT_VALUE));
    }

    public String getFirstInstallmentValue() {
        return firstInstallmentValue().getText();
    }

    public WebElement firstInstallmentCurrency() {
        return getCurrencyWebEl(firstInstallmentValue());
    }

    public String getFirstInstallmentCurrency() {
        return firstInstallmentCurrency().getText();
    }

    private WebElement getCurrencyWebEl(WebElement webElement) {
        WebElement parentElement = webElement.findElement(By.xpath("../.."));
        return parentElement.findElement(By.cssSelector("span[class='input-text']"));
    }
}
