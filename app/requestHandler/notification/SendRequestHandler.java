package requestHandler.notification;

import constants.AppConstants;
import dto.Notification.SendRequest;
import dto.Notification.SendResponse;
import dto.PublishMessage.KafkaMessage;
import enums.KafkaClient;
import messageFormatter.SendMessageFormatter;
import services.KafkaProducerService;

import java.util.HashMap;

public class SendRequestHandler {

    private SendRequest sendRequest;
    private SendResponse sendResponse;

    public SendRequestHandler(SendRequest sendRequest) {
        this.sendRequest = sendRequest;
        this.sendResponse = new SendResponse();
    }

    public SendResponse processRequest() {
        HashMap<String, String> publishStatus = publishMessage();
        if (publishStatus != null) {
            sendResponse.setStatus(AppConstants.RESPONSE_STATUS.SUCCESS.toString());
            sendResponse.setMessage("Sent Successfully");
        } else {
            sendResponse.setStatus(AppConstants.RESPONSE_STATUS.FAILURE.toString());
            sendResponse.setMessage(AppConstants.DEFAULT_ERROR_MESSAGE);
        }
        return sendResponse;
    }

    private HashMap<String, String> publishMessage() {
        SendMessageFormatter sendMessageFormatter = new SendMessageFormatter(sendRequest);
        KafkaMessage kafkaMessage = sendMessageFormatter.getMessage();
        KafkaProducerService kafkaProducerService = new KafkaProducerService(KafkaClient.PUBLISH_NOTIFICATION.getKafkaClient());
        HashMap<String, String> publishStatus = kafkaProducerService.publishMessage(sendRequest.getTopic(), kafkaMessage);
        return publishStatus;
    }
}
