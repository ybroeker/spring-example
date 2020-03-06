package gpse.example.domain;

import java.util.List;

public interface BlogService {
    List<Article> getArticles();

    Article addArticle(User user, String title, String text);

    Article getArticle(String id);

    // tag::add_comment[]
    Article addComment(String id, String comment);
    // end::add_comment[]

}
