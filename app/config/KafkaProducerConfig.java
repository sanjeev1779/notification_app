package config;

import lombok.Data;

import java.util.Map;

@Data
public class KafkaProducerConfig {
    private Map<String, Object> properties;
}
