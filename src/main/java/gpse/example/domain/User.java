package gpse.example.domain;

import javax.persistence.*;

// tag::jpa[]
@Entity //<1>
public class User {

    @Id
    @Column
    private String username;//<2>

    @Column
    private String firstname; //<3>

    @Column
    private String lastname; //<3>

    protected User() { //<4>

    }

    // end::jpa[]


    public User(final String username, final String firstname, final String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
