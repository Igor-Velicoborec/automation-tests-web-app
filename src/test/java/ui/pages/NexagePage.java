package ui.pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import lombok.Getter;
import org.openqa.selenium.By;
import ui.forms.TestForm;

@Getter
public class NexagePage extends Form {
    private final static String LOCATOR_FOR_NEXAGE_PAGE = "//li[text()='Nexage']";
    private TestForm testForm = new TestForm();
    private ILabel numberPage = getElementFactory().getLabel(By.xpath("//a[text()='1']"), "Namber page");

    public NexagePage() {
        super(By.xpath(LOCATOR_FOR_NEXAGE_PAGE), "Nexage page");
    }

    public boolean firstPageIsDisplayed() {
        numberPage.state().waitForDisplayed();
        return numberPage.state().isDisplayed();
    }
}
