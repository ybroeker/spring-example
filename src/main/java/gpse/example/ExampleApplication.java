package gpse.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
// tag::class[]
@SpringBootApplication
@EnableJpaRepositories // <1>
@EnableTransactionManagement// <2>
public class ExampleApplication {
// end::class[]

    public static void main(final String... args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}
