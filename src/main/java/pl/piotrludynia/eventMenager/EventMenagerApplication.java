package pl.piotrludynia.eventMenager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.piotrludynia.eventMenager.user.UserRepository;

@SpringBootApplication
public class EventMenagerApplication {


	public static void main(String[] args) {
		SpringApplication.run(EventMenagerApplication.class, args);
	}

}
