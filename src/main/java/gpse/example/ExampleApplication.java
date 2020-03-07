package gpse.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class ExampleApplication {

    public static void main(final String... args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}
