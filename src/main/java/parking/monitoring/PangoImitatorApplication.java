package parking.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PreDestroy;

@SpringBootApplication
public class PangoImitatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PangoImitatorApplication.class, args);
	}
	
	@PreDestroy
	void preDestroy() {
		System.out.println("PangoImitatorAppl - shutdown has been performed");
	}

}
