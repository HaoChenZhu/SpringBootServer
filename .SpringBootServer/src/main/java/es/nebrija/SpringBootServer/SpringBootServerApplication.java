package es.nebrija.SpringBootServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"es.nebrija.SpringBootServer"})
public class SpringBootServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServerApplication.class, args);
	}

}
