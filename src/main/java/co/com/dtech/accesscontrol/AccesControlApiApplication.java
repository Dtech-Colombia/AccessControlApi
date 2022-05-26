package co.com.dtech.accesscontrol;

import java.io.PrintStream;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"co.com.dtech.accesscontrol.repository"})
public class AccesControlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccesControlApiApplication.class, args);
	}

}
