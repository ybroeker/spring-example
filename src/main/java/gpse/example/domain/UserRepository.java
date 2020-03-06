package gpse.example.domain;

// tag::class[]
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
// end::class[]
