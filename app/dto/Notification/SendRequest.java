package dto.Notification;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SendRequest {

    @NotNull
    @JsonProperty("request_id")
    String requestId;

    @NotNull
    @JsonProperty("topic")
    String topic;

    @NotNull
    @JsonProperty("notification_data")
    HashMap<String, Object> notificationData;
}
