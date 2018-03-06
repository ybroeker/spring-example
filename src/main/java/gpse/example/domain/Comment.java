package gpse.example.domain;

import java.time.LocalDateTime;

import javax.persistence.*;

// tag::jpa[]
@Entity//<1>
public class Comment {

    @Id
    @GeneratedValue
    @Column
    Long id; //<2>

    @Lob
    @Column//<3>
    private String text;

    @Column//<4>
    private LocalDateTime writtenAt;

    protected Comment() { //<5>

    }
    // end::jpa[]

    public Comment(final String text) {
        this.text = text;
        this.writtenAt = LocalDateTime.now();
    }



    public String getText() {
        return text;
    }

    public LocalDateTime getWrittenAt() {
        return writtenAt;
    }
}
