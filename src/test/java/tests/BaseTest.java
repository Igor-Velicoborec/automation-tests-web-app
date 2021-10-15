package tests;

import api.Api;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Cookie;
import utils.BrowserUtils;
import utils.PropertyHolder;
import java.util.List;
import static utils.PropertyHolder.CONFIG_PROPERTIES;
import static utils.PropertyHolder.TEST_PROPERTIES;

public class BaseTest {
    protected final IElementFactory elementFactory;

    protected BaseTest() {
        elementFactory = AqualityServices.getElementFactory();
    }

    @BeforeMethod(alwaysRun = true)
    protected void beforeMethod() {
        String token = Api.getToken(PropertyHolder.getValueProperty("VALUE_VARIANT", TEST_PROPERTIES));
        List<Cookie> cookies = List.of(new Cookie(PropertyHolder.getValueProperty("COOKIE_TOKEN", TEST_PROPERTIES), token));
        BrowserUtils.goTo(PropertyHolder.getValueProperty("BASE_URL_WEB", CONFIG_PROPERTIES));
        BrowserUtils.createCookies(cookies);
        BrowserUtils.goTo(PropertyHolder.getValueProperty("BASE_URL_WEB", CONFIG_PROPERTIES));
        BrowserUtils.maximize();
        BrowserUtils.refresh();
    }

    @AfterMethod(alwaysRun = true)
    protected void afterMethod() {
        if (AqualityServices.isBrowserStarted()) {
           BrowserUtils.quit();
        }
    }
}
