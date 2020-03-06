package gpse.example.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    // tag::test[]

    @Test
    void userCreation() {
        User user = new User("Uncle Bob", "Bob", "Martin","$2a$10$WoG5Z4YN9Z37EWyNCkltyeFr6PtrSXSLMeFWOeDUwcanht5CIJgPa"); // <1>

        assertThat(user.getUsername()).isEqualTo("Uncle Bob");
        assertThat(user.getFirstname()).isEqualTo("Bob");
        assertThat(user.getLastname()).isEqualTo("Martin");
    }
    // end::test[]

}
