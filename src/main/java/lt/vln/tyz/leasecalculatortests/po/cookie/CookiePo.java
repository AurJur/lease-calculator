package lt.vln.tyz.leasecalculatortests.po.cookie;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookiePo {

    private final WebDriver driver;
    private final String COOKIE_PROMPT_MAIN = "div[class='seb-cookie-consent seb-cookiemessage']";
    private final String COOKIE_PROMPT_HEADER = COOKIE_PROMPT_MAIN + " > div > div[class='header-cookie-message']";
    private final String COOKIE_PROMPT_AGREE_BUTTON = COOKIE_PROMPT_MAIN + " li[class='f-left'] > a[class='main accept-selected']";

    public CookiePo(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPrompted() {
        return driver.findElements(By.cssSelector(COOKIE_PROMPT_HEADER)).size() > 0;
    }

    public WebElement agreeButton() {
        return driver.findElement(By.cssSelector(COOKIE_PROMPT_AGREE_BUTTON));
    }
}
