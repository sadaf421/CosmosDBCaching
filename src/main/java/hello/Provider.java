package hello;

import org.springframework.data.annotation.Id;


public class Provider {

    @Id
    public String id;
    
    public int uniqueid;
    public String firstName;
    public String lastName;

    public Provider() {}

    public Provider(int uniqueid,String firstName, String lastName) {
    	this.uniqueid = uniqueid;
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

