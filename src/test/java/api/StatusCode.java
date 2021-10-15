package api;

import lombok.Getter;

@Getter
public enum StatusCode {
    STATUS_CODE_OK(200);

    int value;

    StatusCode(int value) {
        this.value = value;
    }
}
