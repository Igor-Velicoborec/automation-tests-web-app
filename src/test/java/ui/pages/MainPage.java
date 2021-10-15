package ui.pages;

import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import lombok.Getter;
import org.openqa.selenium.By;
import ui.forms.GroupForm;

@Getter
public class MainPage extends Form {
    private final static String LOCATOR_FOR_MAIN_PAGE = "breadcrumb";
    private GroupForm groupForm = new GroupForm();
    private IElement versionNumber = getElementFactory().getLabel(By.xpath("//footer//span"), "Version number");

    public MainPage() {
        super(By.className(LOCATOR_FOR_MAIN_PAGE), "Main page");
    }

    public String getVersionNumber() {
        versionNumber.state().waitForDisplayed();
        return versionNumber.getText();
    }
}
