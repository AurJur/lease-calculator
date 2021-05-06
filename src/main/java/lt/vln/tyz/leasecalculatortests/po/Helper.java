package lt.vln.tyz.leasecalculatortests.po;

import lt.vln.tyz.leasecalculatortests.po.cookie.CookiePo;
import org.openqa.selenium.WebDriver;

public class Helper {

    private final WebDriver driver;
    private final CookiePo cookiePo;

    public Helper(WebDriver driver) {
        this.driver = driver;
        this.cookiePo = new CookiePo(driver);
    }

    public void acceptCookiePolicyIfPrompted() {
        if (cookiePo.isPrompted()) {
            cookiePo.agreeButton().click();
        }
    }
}
