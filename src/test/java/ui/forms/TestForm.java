package ui.forms;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.core.elements.ElementsCount;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

public class TestForm extends Form {
    private static final String LOCATOR_FOR_TEST_FORM = "allTests";
    private static final String LOCATOR_FOR_TESTS = "//table[@class='table']//tbody//tr";

    public TestForm() {
        super(By.id(LOCATOR_FOR_TEST_FORM), "Project form");
    }

    public List<ITextBox> getProjects() {
        return getElementFactory().findElements(By.xpath(LOCATOR_FOR_TESTS), ElementType.TEXTBOX, ElementsCount.MORE_THEN_ZERO, ElementState.DISPLAYED);

    }

    public List<ITextBox> getProjects(int num) {
        List<ITextBox> list = new ArrayList<>();
        for (int i = 1; i < num; i++) {
            list.add(getProjects().get(i));
        }
        return list ;
    }
}
