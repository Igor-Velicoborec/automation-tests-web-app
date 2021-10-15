package utils;

import api.models.Project;
import aquality.selenium.elements.interfaces.ITextBox;
import lombok.experimental.UtilityClass;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ProjectUtils {

    public static boolean isSortedByStartTimeReversed(List<Project> projects) {
        boolean sorted = true;
        for (int i = 0; i < projects.size() - 2; i++) {
            if (projects.get(i).getStartTime().isBefore(projects.get(i + 1).getStartTime())) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    public static List<Project> sortByStartTimeReversed(Project[] projects) {
        return Arrays.stream(projects).sorted(Comparator.comparing(Project::getStartTime).reversed())
                .collect(Collectors.toList());
    }

    public static boolean isApiContainsUiProjects(List<Project> apiList, List<ITextBox> uiList) {
        List<String> apiProjects = apiList.stream()
                .map(Project::toString)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        List<String> uiProjects = uiList.stream()
                .map(ITextBox::getText)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        return apiProjects.containsAll(uiProjects);
    }
}
