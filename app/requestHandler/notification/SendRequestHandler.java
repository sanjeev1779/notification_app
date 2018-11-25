package requestHandler.notification;

import constants.AppConstants;
import dto.Notification.SendRequest;
import dto.Notification.SendResponse;

import java.util.HashMap;

public class SendRequestHandler {

    private SendRequest sendRequest;
    private SendResponse sendResponse = new SendResponse();

    public SendRequestHandler(SendRequest sendRequest) {
        this.sendRequest = sendRequest;
    }

    public SendResponse processRequest() {
        HashMap<String, String> publishStatus = publishRequest();
        if (publishStatus == null) {
            sendResponse.setStatus(AppConstants.RESPONSE_STATUS.SUCCESS.toString());
            sendResponse.setMessage("Sent Successfully");
        } else {
            sendResponse.setStatus(AppConstants.RESPONSE_STATUS.FAILURE.toString());
            sendResponse.setMessage(AppConstants.DEFAULT_ERROR_MESSAGE);
        }
        return sendResponse;
    }

    private HashMap<String, String> publishRequest() {
        HashMap<String, String> publishStatus = new HashMap<String, String>();
//        push to kafka
        return null;
    }
}
