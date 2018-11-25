package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import dto.Notification.SendRequest;
import dto.Notification.SendResponse;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import requestHandler.notification.SendRequestHandler;

public class NotificationController extends Controller {
    public Result index() {
        JsonNode requestBody = request().body().asJson();
        SendRequest sendRequest = Json.fromJson(requestBody, SendRequest.class);
        SendRequestHandler sendRequestHandler = new SendRequestHandler(sendRequest);
        SendResponse sendResponse = sendRequestHandler.processRequest();
        return ok(Json.toJson(sendResponse));
    }
}
