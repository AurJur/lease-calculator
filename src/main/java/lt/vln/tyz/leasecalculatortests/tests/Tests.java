package lt.vln.tyz.leasecalculatortests.tests;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import lt.vln.tyz.leasecalculatortests.po.Helper;
import lt.vln.tyz.leasecalculatortests.po.leasecalc.LeaseCalculatorInputsPo;
import lt.vln.tyz.leasecalculatortests.po.leasecalc.LeaseCalculatorResultsPo;
import lt.vln.tyz.leasecalculatortests.utils.CaseProps;
import lt.vln.tyz.leasecalculatortests.utils.Props;
import lt.vln.tyz.leasecalculatortests.utils.Report;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static lt.vln.tyz.leasecalculatortests.utils.JunitWrapper.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests /*extends TestsBase*/ {

    private WebDriver driver;
    private Helper helper;
    private LeaseCalculatorInputsPo lci;
    private LeaseCalculatorResultsPo lcr;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        helper = new Helper(driver);
        lci = new LeaseCalculatorInputsPo(driver);
        lcr = new LeaseCalculatorResultsPo(driver);
        driver.get(Props.getProperty("lease.calculator.url"));
        driver.manage().window().maximize();
        helper.acceptCookiePolicyIfPrompted();
    }

    @Test
    public void case001_fullSuccessfulPath() {
        ExtentTest test = Report.createTest("case001_fullSuccessfulPath", "Full successful path.");
        CaseProps.setCase("case001");

        lci.switchTo();
        test.info("Switched to lease calculator frame.");

        lci.enterPurchaseValue(CaseProps.getProperty("purchase.value"));
        test.info("Entered 'Purchase value'.");

        lci.enterInterestRate(CaseProps.getProperty("interest.rate"));
        test.info("Entered 'Interest rate'.");

        lci.selectPaymentTerm(CaseProps.getProperty("payment.term"));
        test.info("Selected 'Payment term'.");

        lci.selectEurForFirstInstallment(CaseProps.getProperty("first.installment.selector"));
        test.info("Selected 'First installment' type.");

        lci.enterFirstInstallment(CaseProps.getProperty("first.installment.value"));
        test.info("Entered 'First installment'.");

        lci.enterRemainingValue(CaseProps.getProperty("remaining.value"));
        test.info("Entered 'Remaining value'.");

        lci.clickCalculate();
        test.info("Clicked 'Calculate' button.");

        assertEquals("Asserting monthly payment value.", CaseProps.getProperty("result.monthly.payment.value"), lcr.getMonthlyPaymentValue());
        assertEquals("Asserting monthly payment currency.", CaseProps.getProperty("result.monthly.payment.currency"), lcr.getMonthlyPaymentCurrency());

        assertEquals("Asserting commission fee value.", CaseProps.getProperty("result.commission.fee.value"), lcr.getCommissionFeeValue());
        assertEquals("Asserting commission fee currency.", CaseProps.getProperty("result.commission.fee.currency"), lcr.getCommissionFeeCurrency());

        assertEquals("Asserting first installment value.", CaseProps.getProperty("result.first.installment.value"), lcr.getFirstInstallmentValue());
        assertEquals("Asserting first installment currency.", CaseProps.getProperty("result.first.installment.currency"), lcr.getFirstInstallmentCurrency());
    }

    @Test
    public void case002_testAllIncorrectInputs() {
        ExtentTest test = Report.createTest("case002_testAllIncorrectInputs", "Tests all input fields when incorrect value is entered.");
        CaseProps.setCase("case002_02");

        lci.switchTo();
        test.info("Switched to lease calculator frame.");

        lci.enterPurchaseValue(CaseProps.getProperty("purchase.value"));
        lcr.monthlyPaymentValue().click();
        test.info("Entered 'Purchase value'.");

        assertEquals("Asserting purchase value error text.", CaseProps.getProperty("purchase.value.error"), lci.getPurchaseValueError());

        lci.enterInterestRate(CaseProps.getProperty("interest.rate"));
        lcr.monthlyPaymentValue().click();
        test.info("Entered 'Interest rate'.");

        assertEquals("Asserting interest rate error text.", CaseProps.getProperty("interest.rate.error"), lci.getInterestRateError());

        lci.enterFirstInstallment(CaseProps.getProperty("first.installment.value"));
        lcr.monthlyPaymentValue().click();
        test.info("Entered 'First installment'.");

        assertEquals("Asserting first installment error text.", CaseProps.getProperty("first.installment.error"), lci.getFirstInstallmentError());

        lci.enterRemainingValue(CaseProps.getProperty("remaining.value"));
        lcr.monthlyPaymentValue().click();
        test.info("Entered 'Remaining value'.");

        assertEquals("Asserting remaining value error text.", CaseProps.getProperty("remaining.value.error"), lci.getRemainingValueError());

        lci.clickCalculate();
        test.info("Clicked 'Calculate' button.");

        assertEquals("Asserting purchase value error text.", CaseProps.getProperty("purchase.value.error"), lci.getPurchaseValueError());
        assertEquals("Asserting interest rate error text.", CaseProps.getProperty("interest.rate.error"), lci.getInterestRateError());
        assertEquals("Asserting first installment error text.", CaseProps.getProperty("first.installment.error"), lci.getFirstInstallmentError());
        assertEquals("Asserting remaining value error text.", CaseProps.getProperty("remaining.value.error"), lci.getRemainingValueError());
    }

    @Test
    public void case003_failOnPurpose() {
        ExtentTest test = Report.createTest("case003_failOnPurpose", "Fails on purpose to test report functionality.");
        CaseProps.setCase("case003");

        lci.switchTo();
        test.info("Switched to lease calculator frame.");

        lci.enterPurchaseValue(CaseProps.getProperty("purchase.value"));
        test.info("Entered 'Purchase value'.");

        lci.enterInterestRate(CaseProps.getProperty("interest.rate"));
        test.info("Entered 'Interest rate'.");

        lci.selectPaymentTerm(CaseProps.getProperty("payment.term"));
        test.info("Selected 'Payment term'.");

        lci.selectEurForFirstInstallment(CaseProps.getProperty("first.installment.selector"));
        test.info("Selected 'First installment' type.");

        lci.enterFirstInstallment(CaseProps.getProperty("first.installment.value"));
        test.info("Entered 'First installment'.");

        lci.enterRemainingValue(CaseProps.getProperty("remaining.value"));
        test.info("Entered 'Remaining value'.");

        lci.clickCalculate();
        test.info("Clicked 'Calculate' button.");

        assertEquals("Asserting monthly payment value.", CaseProps.getProperty("result.monthly.payment.value"), lcr.getMonthlyPaymentValue());
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
        Report.flush();
    }
}
