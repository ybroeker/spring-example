package gpse.example.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    private User author;

    @Column
    private String title;

    @Lob
    @Column
    private String text;

    @Column
    private LocalDateTime publishedAt;

    // tag::comments[]
    @OneToMany(cascade = CascadeType.ALL) //<1>
    private List<Comment> comments = new ArrayList<>();
    // end::comments[]

    protected Article() {

    }

    public Article(final User author, final String title, final String text) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.publishedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

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

    public void addComment(final String commentText) {
        this.comments.add(new Comment(commentText));
    }

}
