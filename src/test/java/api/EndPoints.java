package api;

import lombok.Getter;

@Getter
public enum EndPoints {
    PATH_GET_TOKEN("token/get"),
    PATH_GET_TEST_IN_JSON("test/get/json"),
    PATH_ADD_TEST("test/put"),
    PATH_ADD_LOG("test/put/log"),
    PATH_ADD_SCREENSHOT("test/put/attachment");

    String value;

    EndPoints(String value) {
        this.value = value;
    }
}
