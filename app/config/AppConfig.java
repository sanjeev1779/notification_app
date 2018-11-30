package config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@EqualsAndHashCode()
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppConfig {

    @JsonProperty("kafkaProducerConfig")
    Map<String, KafkaProducerConfig> kafkaProducerConfig;
}
