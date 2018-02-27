package tdpe.example.domain;

// tag::class[]
public class User {

    private String username;

    private String firstname;

    private String lastname;

    public User(final String username, final String firstname, final String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }
// end::class[]

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
