package steps;

import api.Api;
import api.models.Project;
import org.testng.Assert;
import utils.PropertyHolder;

import static utils.PropertyHolder.TEST_PROPERTIES;

public class ApiSteps {
    public static void getToken() {
        String token = Api.getToken(PropertyHolder.getValueProperty("VALUE_VARIANT", TEST_PROPERTIES));
        Assert.assertFalse(token.isEmpty(),"Token not valid");
    }

    public static Project[] getApiProjectNexage () {
        return Api.getProjects(PropertyHolder.getValueProperty("VALUE_PROJECT_ID_NEXAGE", TEST_PROPERTIES));
    }
}
