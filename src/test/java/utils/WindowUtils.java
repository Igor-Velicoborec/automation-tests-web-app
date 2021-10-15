package utils;

import aquality.selenium.browser.AqualityServices;
import lombok.experimental.UtilityClass;
import java.util.Set;

@UtilityClass
public class WindowUtils {

    public static String getCurrentWindowHandle() {
        return AqualityServices.getBrowser().getDriver().getWindowHandle();
    }

    public static void switchToWindow(String winHandle) {
        AqualityServices.getBrowser().getDriver().switchTo().window(winHandle);
    }

    public static String getOtherTabWindowHandle(String windowHandle) {
        Set<String> windowHandles = AqualityServices.getBrowser().getDriver().getWindowHandles();
        windowHandles.remove(windowHandle);
        return (String) windowHandles.toArray()[0];
    }
}
