package dto.PublishMessage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageMetaData {

    @NotNull
    @JsonProperty("tenant")
    String tenant;

    @NotNull
    @JsonProperty("topic")
    String topic;

    @JsonProperty("timestamp")
    long timestamp;
}
