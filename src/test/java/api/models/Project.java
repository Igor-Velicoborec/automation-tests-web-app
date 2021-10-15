package api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project implements Serializable {

    private String duration;
    private String method;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.S")
    private LocalDateTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.S")
    private LocalDateTime endTime;
    private String status;
    private String show = "Show";

    @Override
    public String toString() {
        String endTimeStr = endTime != null
                ? endTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")) + " "
                : "";
        return name + " "
                + method + " "
                + status + " "
                + startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S")) + " "
                + endTimeStr
                + duration + " "
                + show;
    }
}
