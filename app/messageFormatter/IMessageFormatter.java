package messageFormatter;

import dto.PublishMessage.MessageMetaData;

import java.util.HashMap;

public interface IMessageFormatter {
    MessageMetaData getMetadata();
    HashMap<String, Object> getData();
}
