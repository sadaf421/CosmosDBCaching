package hello;

import org.springframework.data.annotation.Id;


public class Provider {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Provider() {}

    public Provider(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Provider[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}

