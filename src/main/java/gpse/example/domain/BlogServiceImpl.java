package gpse.example.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class BlogServiceImpl implements BlogService {

    private final ArticleRepository articleRepository;

    @Autowired
    public BlogServiceImpl(final ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getArticles() {
        final List<Article> articles = new ArrayList<>();

        articleRepository.findAll().forEach(articles::add);

        return articles;
    }

    // tag::class[]
    @Override
    public Article addArticle(final User user, final String title, final String text) {
        final Article article = new Article(user, title, text); //<1>

        return articleRepository.save(article); //<2>
    }
    // end::class[]


}
