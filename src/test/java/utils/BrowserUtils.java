package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import lombok.experimental.UtilityClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import java.util.List;

@UtilityClass
public class BrowserUtils {
    private static final Logger logger = LogManager.getLogger(BrowserUtils.class);

    private Browser getBrowser() {
        return AqualityServices.getBrowser();
    }

    public static List<Cookie> createCookies(List<Cookie> cookies) {
        logger.info("create cookies");
        for (Cookie cookie : cookies) {
            getBrowser().getDriver().manage().addCookie(cookie);
        }
        return cookies;
    }

    public static void goTo(String url) {
        getBrowser().goTo(url);
    }

    public static void maximize() {
        getBrowser().maximize();
    }

    public static void refresh() {
        getBrowser().getDriver().navigate().refresh();
    }

    public static void goBack() {
        getBrowser().goBack();
    }

    public static void closePopUp() {
        getBrowser().getDriver().close();
    }

    public static void quit() {
        AqualityServices.getBrowser().quit();
    }

    public static byte[] getScreenshot() {
        return getBrowser().getScreenshot();
    }
}
