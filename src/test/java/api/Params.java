package api;

import lombok.Getter;

@Getter
public enum Params {
    PARAM_TEST_ID("testId"),
    PARAM_CONTENT("content"),
    PARAM_CONTENT_TYPE("contentType"),
    PARAM_SID("SID"),
    PARAM_PROJECT_NAME("projectName"),
    PARAM_TEST_NAME("testName"),
    PARAM_METHOD_NAME("methodName"),
    PARAM_ENV("env"),
    PARAM_VARIANT("variant"),
    PARAM_PROJECT_ID("projectId");

    String value;

    Params(String value) {
        this.value = value;
    }
}
