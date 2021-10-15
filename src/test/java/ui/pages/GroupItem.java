package ui.pages;

import lombok.Getter;
import utils.PropertyHolder;

import static utils.PropertyHolder.TEST_PROPERTIES;

@Getter
public enum GroupItem {
    NEXAGE("Nexage"),
    PROJECT(PropertyHolder.getValueProperty("PROJECT_NAME", TEST_PROPERTIES));

    private String getLog;

    GroupItem(String getLog) {
        this.getLog = getLog;
    }
}
