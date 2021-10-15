package ui.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AddProjectPage extends Form {
    private final static String LOCATOR_FOR_ADD_PROJECT_PAGE = "//div[contains(@class,'container')]";
    private ITextBox setProjectName = getElementFactory().getTextBox(By.id("projectName"), "Set project name");
    private IButton saveProjectBtn = getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Save project btn");
    private ITextBox savedSuccessfully = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'alert-success')]"), "Saved successfully");

    public AddProjectPage() {
        super(By.xpath(LOCATOR_FOR_ADD_PROJECT_PAGE), "Add project page");
    }

    private void setProjectName(String projectName) {
        setProjectName.state().waitForDisplayed();
        setProjectName.sendKeys(projectName);
    }
    public void addProjectNameAndSave(String projectName) {
        setProjectName(projectName);
        saveProjectBtn.click();
    }

    public boolean isSavedSuccessfully() {
        return savedSuccessfully.state().isDisplayed();
    }
}
