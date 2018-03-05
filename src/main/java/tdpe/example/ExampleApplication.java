package tdpe.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// tag::class[]
@SpringBootApplication // <1>
public class ExampleApplication {

    public static void main(final String... args) {
        SpringApplication.run(ExampleApplication.class, args); // <2>
    }
}
// end::class[]
