package tdpe.example.domain;

import java.time.LocalDateTime;

// tag::class[]

public class Comment {

    private String text;

    private LocalDateTime writtenAt;

    public Comment(final String text) {
        this.text = text;
        this.writtenAt = LocalDateTime.now(); //<1>
    }
    // end::class[]


    public String getText() {
        return text;
    }

    public LocalDateTime getWrittenAt() {
        return writtenAt;
    }
}
