package messageFormatter;

import dto.Notification.SendRequest;
import dto.PublishMessage.KafkaMessage;
import dto.PublishMessage.MessageMetaData;

import java.util.HashMap;

public class SendMessageFormatter implements IMessageFormatter {
    private final SendRequest sendRequest;

    public SendMessageFormatter(SendRequest sendRequest) {
        this.sendRequest = sendRequest;
    }

    @Override
    public MessageMetaData getMetadata() {
        MessageMetaData messageMetaData = new MessageMetaData();
        messageMetaData.setTimestamp(System.currentTimeMillis());
        messageMetaData.setTenant(null); // @TODO take tenant in header in sendRequest
        messageMetaData.setTopic(sendRequest.getTopic());
        return messageMetaData;
    }

    @Override
    public HashMap<String, Object> getData() {
        HashMap<String, Object> notificationData = sendRequest.getNotificationData();
        return notificationData;
    }

    public KafkaMessage getMessage() {
        KafkaMessage kafkaMessage = new KafkaMessage();
        kafkaMessage.setId(sendRequest.getRequestId());
        kafkaMessage.setMetaData(getMetadata());
        kafkaMessage.setData(getData());
        return kafkaMessage;
    }
}
