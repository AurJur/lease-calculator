package lt.vln.tyz.leasecalculatortests.utils;

import com.aventstack.extentreports.Status;
import org.junit.Assert;

public class JunitWrapper {

    public static void assertEquals(String message, String expected, String actual) {
        try {
            Assert.assertEquals(message, expected, actual);
            Report.extentTest.log(Status.PASS, "PASS -- " + message);
        } catch (AssertionError error) {
            Report.extentTest.log(Status.FAIL, "FAIL -- " + message + "<br>" + error);
            throw new AssertionError();
        } finally {
            Report.flush();
        }
    }
}
