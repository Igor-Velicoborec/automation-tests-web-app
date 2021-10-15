package api;

import api.models.Project;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.JsonUtils;
import utils.PropertyHolder;
import java.util.Base64;
import static io.restassured.RestAssured.given;
import static utils.PropertyHolder.TEST_PROPERTIES;

public class Api {
    private static final Logger logger = LogManager.getLogger(Api.class);

    public static String getToken(String variantValue) {
        logger.info("Get token in Api class");
        return given()
                .baseUri(PropertyHolder.getValueProperty("BASE_URL_API", TEST_PROPERTIES))
                .basePath(EndPoints.PATH_GET_TOKEN.getValue())
                .queryParam(Params.PARAM_VARIANT.getValue(), variantValue)
                .when().post().then()
                .statusCode(StatusCode.STATUS_CODE_OK.getValue())
                .extract().body().asString();
    }

    public static Project[] getProjects(String projectId) {
        String responseString = getProjectsString(projectId);
        return JsonUtils.decode(responseString, Project[].class);
    }

    private static String getProjectsString(String projectId) {
        logger.info("Get projects in api class");
        return given()
                .baseUri(PropertyHolder.getValueProperty("BASE_URL_API", TEST_PROPERTIES))
                .basePath(EndPoints.PATH_GET_TEST_IN_JSON.getValue())
                .queryParam(Params.PARAM_PROJECT_ID.getValue(), projectId)
                .when().post().then()
                .statusCode(StatusCode.STATUS_CODE_OK.getValue())
                .extract().body().asString();
    }

    public static boolean isJsonResponseGetProjects(String projectId) {
        boolean valid = true;
        String responseString = getProjectsString(projectId);
        if (!responseString.startsWith("["))
            valid = false;
        return valid;
    }

    public static String addTest(String projectName, String testName, String methodName) {
        logger.info("Add test in Api class");
        return given()
                .baseUri(PropertyHolder.getValueProperty("BASE_URL_API", TEST_PROPERTIES))
                .basePath(EndPoints.PATH_ADD_TEST.getValue())
                .queryParam(Params.PARAM_SID.getValue(), PropertyHolder.getValueProperty("SID_VALUE", TEST_PROPERTIES))
                .queryParam(Params.PARAM_PROJECT_NAME.getValue(), projectName)
                .queryParam(Params.PARAM_TEST_NAME.getValue(), testName)
                .queryParam(Params.PARAM_METHOD_NAME.getValue(), methodName)
                .queryParam(Params.PARAM_ENV.getValue(), PropertyHolder.getValueProperty("ENV_VALUE_START_TIME", TEST_PROPERTIES))
                .when().post().then()
                .statusCode(StatusCode.STATUS_CODE_OK.getValue())
                .extract().body().asString();
    }

    public static void addLogInTest(String testId) {
        logger.info("Add log in test");
        given()
                .baseUri(PropertyHolder.getValueProperty("BASE_URL_API", TEST_PROPERTIES))
                .basePath(EndPoints.PATH_ADD_LOG.getValue())
                .queryParam(Params.PARAM_TEST_ID.getValue(), testId)
                .queryParam(Params.PARAM_CONTENT.getValue(), PropertyHolder.getValueProperty("CONTENT_VALUE", TEST_PROPERTIES))
                .when().post().then()
                .statusCode(StatusCode.STATUS_CODE_OK.getValue());
    }

    public static void addScreenshot(byte[] content, String testId) {
        logger.info("Add screenshot in test");
        String encoded = Base64.getEncoder().encodeToString(content);
        given()
                .baseUri(PropertyHolder.getValueProperty("BASE_URL_API", TEST_PROPERTIES))
                .basePath(EndPoints.PATH_ADD_SCREENSHOT.getValue())
                .queryParam(Params.PARAM_TEST_ID.getValue(), testId)
                .formParam(Params.PARAM_CONTENT.getValue(), encoded)
                .queryParam(Params.PARAM_CONTENT_TYPE.getValue(), ContentType.CONTENT_TYPE_IMAGE.getValue())
                .when().post().then()
                .statusCode(StatusCode.STATUS_CODE_OK.getValue());
    }
}
