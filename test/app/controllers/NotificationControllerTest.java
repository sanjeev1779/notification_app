package app.controllers;

import dto.Notification.SendRequest;
import org.junit.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.assertEquals;


public class NotificationControllerTest {

//    SendRequest sendRequestMock = mock(SendRequest.class);
    @Test
    public void send() {
        SendRequest sendRequest = new SendRequest();
        sendRequest.setRequestId(UUID.randomUUID().toString());
        sendRequest.setTopic("otp");
        HashMap<String, Object> notification_data = new HashMap<>();
        notification_data.put("name", "Sanjeev");
        sendRequest.setNotificationData(notification_data);
        assertEquals(sendRequest.getTopic(), "otp");
    }
}
