package rt.hw6;

import org.springframework.boot.SpringApplication;

public class TestHw6Application {

	public static void main(String[] args) {
		SpringApplication.from(Hw6Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
