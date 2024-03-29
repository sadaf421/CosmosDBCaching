package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProviderRepository extends MongoRepository<Provider, String> {
	

    public Provider findByFirstName(String firstName);
    public Provider findByUniqueId(int uniqueid);
    public List<Provider> findByLastName(String lastName);
    
    
}
