package rt.ex1.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "inChannel")
public interface FileOut {

    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, String dataToSave);
}
