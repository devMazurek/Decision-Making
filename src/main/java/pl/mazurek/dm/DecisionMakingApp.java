package pl.mazurek.dm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("pl.mazurek.dm")
public class DecisionMakingApp {

	public static void main(String[] args) {
		SpringApplication.run(DecisionMakingApp.class, args);

	}

}
