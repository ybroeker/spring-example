package gpse.example.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// tag::class[]
@Service
public class BlogServiceImpl implements BlogService {

    private final ArticleRepository articleRepository;

    @Autowired //<1>
    public BlogServiceImpl(final ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getArticles() {
        final List<Article> articles = new ArrayList<>();

        articleRepository.findAll().forEach(articles::add); //<2>

        return articles;
    }
}
// end::class[]
