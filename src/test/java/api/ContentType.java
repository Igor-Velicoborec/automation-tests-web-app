package api;

import lombok.Getter;

@Getter
public enum ContentType {
    CONTENT_TYPE_IMAGE("image/png");

    String value;

    ContentType(String value) {
        this.value = value;
    }
}
