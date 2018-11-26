package enums;

import lombok.Getter;

public enum KafkaClient {
    PUBLISH_NOTIFICATION("publish_notification");

    @Getter
    private String kafkaClient;

    KafkaClient(String kafkaClient) {
        this.kafkaClient = kafkaClient;
    }
}
