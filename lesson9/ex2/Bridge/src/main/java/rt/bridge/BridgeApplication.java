package rt.bridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BridgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BridgeApplication.class, args);
	}

}
// Добавил данное приложение для того, чтобы отправлять запросы к микросервисам А и Б,
// используя порт именно этого приложения, а не самих микросервисов