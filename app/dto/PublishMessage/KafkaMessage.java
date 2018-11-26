package dto.PublishMessage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KafkaMessage {

    @NotNull
    @JsonProperty("id")
    String id;

    @NotNull
    @JsonProperty("metaData")
    MessageMetaData metaData;

    @JsonProperty("data")
    HashMap<String, Object> data;
}
