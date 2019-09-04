package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProviderRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of Provider
		repository.save(new Provider("sadaf", "ali"));
		repository.save(new Provider("Urvashi", "Gautam"));

		// fetch all Provider
		System.out.println("Provider found with findAll():");
		System.out.println("-------------------------------");
		for (Provider customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual Provider
		System.out.println("Provider found with findByFirstName('sadaf'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("sadaf"));

		System.out.println("Provider found with findByLastName('Urvashi'):");
		System.out.println("--------------------------------");
		for (Provider customer : repository.findByLastName("Urvashi")) {
			System.out.println(customer);
		}

	}

}
