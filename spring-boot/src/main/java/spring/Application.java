package spring;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import spring.entities.Account;
import spring.entities.Customer;
import spring.repository.CustomerRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Hello Spring boot");
	}
	
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			repository.save(new Customer());
			repository.save(new Customer());
			repository.findAll().forEach(cust -> System.out.println("The application is" + cust.toString()));
		
		} ;
	}

}
