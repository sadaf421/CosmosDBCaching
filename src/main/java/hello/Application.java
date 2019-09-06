package hello;

import java.util.Random;

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
	protected String getProviderString() {
        String ProviderCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * ProviderCHARS.length());
            salt.append(ProviderCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();

		// save a couple of Provider
		for(int i=0;i<1000;i++) {
			repository.save(new Provider(getProviderString(), getProviderString()));
		}
		
		
		
		//repository.save(new Provider("Urvashi", "Gautam"));

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
		for (Provider provider : repository.findByLastName("Urvashi")) {
			System.out.println(provider);
		}

	}

}
