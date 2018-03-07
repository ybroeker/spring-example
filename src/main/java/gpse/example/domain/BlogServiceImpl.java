package gpse.example.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

// tag::class[]
@Service //<1>
public class BlogServiceImpl implements BlogService {

    @Override
    public List<Article> getArticles() {
        final User user = new User("Uncle Bob", "Bob", "Martin");

        final List<Article> articles = new ArrayList<>();
        articles.add(new Article(user, "A magnificent Article", "Lorem ipsum dolor"));
        articles.add(new Article(user, "Another Article", "sit amet, consetetur sadipscing elitr"));

        return articles;
    }
}
// end::class[]
