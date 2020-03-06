package gpse.example.web;

import javax.validation.constraints.NotBlank;

public class CreateArticleCmd {
// tag::validation[]

    @NotBlank// <1>
            String title;
    @NotBlank
    String text;
// end::validation[]

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
