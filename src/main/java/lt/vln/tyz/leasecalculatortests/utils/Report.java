package lt.vln.tyz.leasecalculatortests.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Report {

    //todo: make report fail if test does not start or is interrupted in the middle.

    private static boolean created = false;
    private static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public static ExtentTest createTest(String testName, String description) {
        createReporter();
        extentTest = extentReports.createTest(testName, description);
        return extentTest;
    }

    public static void flush() {
        createReporter();
        extentReports.flush();
    }

    private static void createReporter() {
        if (!created) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd_HH-mm");
            String now = LocalDateTime.now().format(dateTimeFormatter);
            ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter("lease-calc_" + now + ".html");
            extentReports = new ExtentReports();
            extentReports.attachReporter(extentHtmlReporter);
            created = true;
        }
    }
}
