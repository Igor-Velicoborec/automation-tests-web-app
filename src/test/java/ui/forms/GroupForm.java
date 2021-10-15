package ui.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import ui.pages.GroupItem;

public class GroupForm extends Form {
    private static final Logger logger = LogManager.getLogger(GroupForm.class);
    private final static String LOCATOR_FOR_GROUP_FORM ="//div[contains(@class,'panel-default')]";
    private String LOG_TEMPLATE = "//div[@class='list-group']//a[text()='%s']";
    private IButton addProject = getElementFactory().getButton(By.xpath("//a[@target='_blank']"), "Add project btn");

    public GroupForm() {
        super(By.xpath(LOCATOR_FOR_GROUP_FORM), "Group form");
    }

    public void selectGroup(GroupItem groupItem) {
        logger.info("Select "+groupItem.getGetLog());
        IElement element = getElementFactory().getLabel(By.xpath(String.format(LOG_TEMPLATE, groupItem.getGetLog())),groupItem.getGetLog());
        element.state().waitForClickable();
        element.click();
    }

    public void addProject() {
        addProject.state().waitForClickable();
        addProject.click();
    }
    public boolean isAddedProject(GroupItem groupItem) {
        IElement element = getElementFactory().getLabel(By.xpath(String.format(LOG_TEMPLATE, groupItem.getGetLog())),groupItem.getGetLog());
        element.state().waitForDisplayed();
        return element.state().isDisplayed();
    }
}
