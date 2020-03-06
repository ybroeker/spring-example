package gpse.example.web;

import javax.validation.constraints.NotBlank;

public class AddCommentCmd {

    @NotBlank
    private String text;

    public AddCommentCmd() {
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
