package gpse.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
// tag::class[]
@SpringBootApplication // <1>
public class ExampleApplication {

    public static void main(final String... args) {
        SpringApplication.run(ExampleApplication.class, args); // <2>
    }
}
// end::class[]
