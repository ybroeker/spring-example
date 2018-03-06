package gpse.example.domain;

import java.util.List;

import gpse.example.domain.Article;

// tag::class[]
public interface BlogService {
    List<Article> getArticles();
}
// end::class[]
