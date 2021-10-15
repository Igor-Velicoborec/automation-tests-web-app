package tests;

import api.Api;
import api.models.Project;
import aquality.selenium.elements.interfaces.ITextBox;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.*;
import utils.BrowserUtils;
import utils.PropertyHolder;
import utils.ProjectUtils;
import utils.WindowUtils;
import java.util.List;

import static utils.PropertyHolder.TEST_PROPERTIES;

public class TestApp extends BaseTest {
    private MainPage mainPage;
    private NexagePage nexagePage;
    private AddProjectPage addProjectPage;
    private CreatedProjectPage createdProjectPage;
    private static final int NUMBER_OF_UI_PROJECT = 10;
    private static final String PROJECT_NAME = PropertyHolder.getValueProperty("PROJECT_NAME", TEST_PROPERTIES);
    private static final String VERSION_NUMBER = PropertyHolder.getValueProperty("VERSION_NUMBER", TEST_PROPERTIES);
    private static final String TEST_NAME = PropertyHolder.getValueProperty("TEST_NAME", TEST_PROPERTIES);
    private static final String TEST_METHOD_NAME = PropertyHolder.getValueProperty("TEST_METHOD_NAME", TEST_PROPERTIES);
    private static final String VALUE_PROJECT_ID_NEXAGE = PropertyHolder.getValueProperty("VALUE_PROJECT_ID_NEXAGE", TEST_PROPERTIES);

    @Test
    public void testApp() {
        String token = Api.getToken(PropertyHolder.getValueProperty("VALUE_VARIANT", TEST_PROPERTIES));
        Assert.assertFalse(token.isEmpty(),"Token not valid");
        mainPage = new MainPage();
        Assert.assertEquals(mainPage.getVersionNumber(), VERSION_NUMBER, "Not valid number");
        mainPage.getGroupForm().selectGroup(GroupItem.NEXAGE);
        Project[] apiProjects = Api.getProjects(VALUE_PROJECT_ID_NEXAGE);
        Assert.assertTrue(Api.isJsonResponseGetProjects(VALUE_PROJECT_ID_NEXAGE), "Response not json");
        List<Project> apiSortedProjects = ProjectUtils.sortByStartTimeReversed(apiProjects);
        Assert.assertTrue(ProjectUtils.isSortedByStartTimeReversed(apiSortedProjects), "Projects not sorted");
        nexagePage = new NexagePage();
        Assert.assertTrue(nexagePage.firstPageIsDisplayed(), "First page not displayed");
        List<ITextBox> uiProjects = nexagePage.getTestForm().getProjects(NUMBER_OF_UI_PROJECT);
        Assert.assertTrue(ProjectUtils.isApiContainsUiProjects(apiSortedProjects,uiProjects), "Api projects not contains iu projects");
        BrowserUtils.goBack();

        String parentWindowHandle = WindowUtils.getCurrentWindowHandle();
        mainPage.getGroupForm().addProject();
        String childWindowHandle = WindowUtils.getOtherTabWindowHandle(parentWindowHandle);
        WindowUtils.switchToWindow(childWindowHandle);

        addProjectPage = new AddProjectPage();
        addProjectPage.addProjectNameAndSave(PROJECT_NAME);
        Assert.assertTrue(addProjectPage.isSavedSuccessfully(), "Project not saved");
        BrowserUtils.closePopUp();
        WindowUtils.switchToWindow(parentWindowHandle);
        BrowserUtils.refresh();
        Assert.assertTrue(mainPage.getGroupForm().isAddedProject(GroupItem.PROJECT), "Project not added");
        mainPage.getGroupForm().selectGroup(GroupItem.PROJECT);
        String projectId = Api.addTest(PropertyHolder.getValueProperty("PROJECT_NAME", TEST_PROPERTIES), TEST_NAME, TEST_METHOD_NAME);
        Api.addLogInTest(projectId);
        createdProjectPage = new CreatedProjectPage();
        Api.addScreenshot(createdProjectPage.getScreenshotBytes(), projectId);
        Assert.assertTrue(createdProjectPage.isAddedTest(),"Test not added");
    }
}
