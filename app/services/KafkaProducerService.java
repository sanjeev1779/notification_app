package services;

import com.fasterxml.jackson.databind.JsonNode;
import config.KafkaProducerConfig;
import dto.PublishMessage.KafkaMessage;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import play.libs.Json;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class KafkaProducerService {

    private KafkaProducerConfig kafkaProducerConfig;
    private KafkaProducer<String, String> kafkaProducer;

    public KafkaProducerService(String producerClient) {
        setKafkaProducerConfig(producerClient);
        kafkaProducer = new KafkaProducer<>(kafkaProducerConfig.getProperties());
        //@TODO fix it
//        kafkaProducer = new KafkaProducer<>(configuration.getObjectList("kafkaProducerConfig.publish_notification.properties"));
    }

    private void setKafkaProducerConfig(String producerClient) {
        //@TODO get this data from config
//        AppConfig appConfig = new AppConfig();
//        kafkaProducerConfig = appConfig.getKafkaProducerConfig().get(producerClient);
//        System.out.println("producerClient start");
//        System.out.println(producerClient);
//        System.out.println("producerClient end");
//        System.out.println(ToStringBuilder.reflectionToString(appConfig.getKafkaProducerConfig().get("publish_notification")));
//        System.out.println("producerClient end2");
//        System.out.println(ToStringBuilder.reflectionToString(appConfig.getKafkaProducerConfig().get(producerClient)));
//        System.out.println("producerClient end3");

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("delivery.timeout.ms", 3000);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProducerConfig = new KafkaProducerConfig();
        kafkaProducerConfig.setProperties((Map) props);
    }

    public HashMap<String, String> publishMessage(String topic, KafkaMessage kafkaMessage) {
        JsonNode requestBody = Json.toJson(kafkaMessage);
        HashMap<String, String> response = publishMessage(topic, requestBody);
        return response;
    }

    public HashMap<String, String> publishMessage(String topic, JsonNode requestBody) {
        kafkaProducer.send(new ProducerRecord<>(topic, requestBody.toString()));
        return null;
    }
}
