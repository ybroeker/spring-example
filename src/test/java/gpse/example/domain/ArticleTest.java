package gpse.example.domain;
// tag::test[]

import java.time.LocalDateTime;

import gpse.example.domain.Article;
import gpse.example.domain.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArticleTest {

    @Test
    void getTitle() {
        LocalDateTime testStarted = LocalDateTime.now();

        User user = new User("testuser", "Test", "User", "$2a$10$WoG5Z4YN9Z37EWyNCkltyeFr6PtrSXSLMeFWOeDUwcanht5CIJgPa");
        Article article = new Article(user, "A short title", "Some text...");


        assertThat(article.getTitle()).isEqualTo("A short title");
        assertThat(article.getText()).isEqualTo("Some text...");
        assertThat(article.getPublishedAt())
                .isAfterOrEqualTo(testStarted)
                .isBeforeOrEqualTo(LocalDateTime.now());
        assertThat(article.getComments()).isEmpty();
    }

    @Test
    void addComment() {
        LocalDateTime testStarted = LocalDateTime.now();

        User user = new User("testuser", "Test", "User", "$2a$10$WoG5Z4YN9Z37EWyNCkltyeFr6PtrSXSLMeFWOeDUwcanht5CIJgPa");
        Article article = new Article(user, "A short title", "Some text...");

        assertThat(article.getComments()).isEmpty();

        article.addComment("A first Comment");

        assertThat(article.getComments()).hasSize(1);
        assertThat(article.getComments().get(0).getText()).isEqualTo("A first Comment");
        assertThat(article.getComments().get(0).getWrittenAt())
                .isAfterOrEqualTo(testStarted)
                .isBeforeOrEqualTo(LocalDateTime.now());

    }
}
// end::test[]
