package rt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Задание:
	// Продемонстрируйте применение Spring AOP для логирования операций в вашем приложении.
	// Подумайте, как можно применить управление транзакциями для обеспечения целостности данных.
}