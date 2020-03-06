package gpse.example.domain;

import java.util.List;

// tag::class[]
public interface BlogService {
    List<Article> getArticles();

    Article addArticle(User user, String title, String text); //<1>
}
// end::class[]
