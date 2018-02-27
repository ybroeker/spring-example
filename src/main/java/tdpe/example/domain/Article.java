package tdpe.example.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// tag::class[]
public class Article {
    private User author;

    private String title;

    private String text;

    private LocalDateTime publishedAt;

    private List<Comment> comments = new ArrayList<>(); //<1>

    public Article(final User author, final String title, final String text) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.publishedAt = LocalDateTime.now();//<2>
    }
    // end::class[]

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public User getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return comments;
    }
// tag::add-comment[]
    public void addComment(String commentText) {
        this.comments.add(new Comment(commentText));
    }
    // end::add-comment[]

}
