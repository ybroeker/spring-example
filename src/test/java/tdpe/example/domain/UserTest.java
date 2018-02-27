package tdpe.example.domain;
// tag::test[]
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void userCreation() {
        User user = new User("Uncle Bob", "Bob", "Martin");

        assertThat(user.getUsername()).isEqualTo("Uncle Bob");
        assertThat(user.getFirstname()).isEqualTo("Bob");
        assertThat(user.getLastname()).isEqualTo("Martin");
    }

}
// end::test[]
