package gpse.example.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

// tag::jpa[]
@Entity //<1>
public class Article {

    @Id
    @GeneratedValue
    @Column
    private Long id; //<2>

    @ManyToOne //<3>
    private User author;

    @Column //<4>
    private String title;

    @Lob
    @Column //<5>
    private String text;

    @Column //<6>
    private LocalDateTime publishedAt;

    @OneToMany //<7>
    private List<Comment> comments = new ArrayList<>();

    protected Article() { //<8>

    }
    // end::jpa[]

    public Article(final User author, final String title, final String text) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.publishedAt = LocalDateTime.now();
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
