package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProviderTwoRepository extends MongoRepository<Provider, String> {

    public Provider_two findByFirstName(String firstName);
    public List<Provider_two> findByLastName(String lastName);
    
    
}