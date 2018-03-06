package gpse.example.domain;

// tag::class[]
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
// end::class[]
