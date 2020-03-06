package gpse.example.web;

// tag::class[]
public class CreateArticleCmd {

    private String title;

    private String text;

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
// end::class[]
