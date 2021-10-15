package ui.pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.BrowserUtils;

public class CreatedProjectPage extends Form {
    private final static String LOCATOR_FOR_CREATED_PROJECT_PAGE = "//a[text()='Home']";
    private ILabel testHistory = getElementFactory().getLabel(By.xpath("//td//a[text()='Show']"), "Test history");

    public CreatedProjectPage() {
        super(By.xpath(LOCATOR_FOR_CREATED_PROJECT_PAGE), "Created project page");
    }

    public boolean isAddedTest() {
        testHistory.state().waitForDisplayed();
        return testHistory.state().isDisplayed();
    }

    public byte[] getScreenshotBytes() {
        return BrowserUtils.getScreenshot();
    }
}
