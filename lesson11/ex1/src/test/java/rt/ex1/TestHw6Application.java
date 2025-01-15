package rt.ex1;

import org.springframework.boot.SpringApplication;

public class TestHw6Application {

	public static void main(String[] args) {
		SpringApplication.from(Ex1Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
