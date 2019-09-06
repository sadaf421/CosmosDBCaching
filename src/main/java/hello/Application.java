package hello;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProviderRepository repository;
	@Autowired
	private ProviderTwoRepository repository_two;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	protected String getProviderString() {
        String ProviderCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb= new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * ProviderCHARS.length());
            sb.append(ProviderCHARS.charAt(index));
        }
        String saltStr = sb.toString();
        return saltStr;

    }
	@Override
	public void run(String... args) throws Exception {
		
		//repository.deleteAll();

		// save a couple of Provider
		/*for(int i=0;i<10000;i++) {
			//repository.save(new Provider(getProviderString(), getProviderString()));
			repository_two.save(new Provider_two(getProviderString(), getProviderString()));
		}*/
		
		
		
		//repository.save(new Provider("Urvashi", "Gautam"));

		// fetch all Provider
		long startTime = System.nanoTime();
		System.out.println("Provider found with findAll():");
		System.out.println("-------------------------------");
		
		for (Provider provider : repository.findAll()) {
			System.out.println(provider);
		}
		
		
		
		
		System.out.println("providerTwo found with findAll():");
		System.out.println("-------------------------------");
		for (Provider providerTwo : repository.findAll()) {
			System.out.println(providerTwo);
		}
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println(" Time taken to read 21000 records from two different documents ---------> "+TimeUnit.NANOSECONDS.toMillis(duration) +"ms"+" \n provider 1 count --->"+repository.count()+" \n provider 2 count --->"+repository_two.count());

		/*fetch an individual Provider
		System.out.println("Provider found with findByFirstName('sadaf'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("sadaf"));

		System.out.println("Provider found with findByLastName('Urvashi'):");
		System.out.println("--------------------------------");
		for (Provider provider : repository.findByLastName("Urvashi")) {
			System.out.println(provider);
		}*/

	}

}
