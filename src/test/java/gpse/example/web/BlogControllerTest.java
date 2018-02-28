package gpse.example.web;
// tag::test[]
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;

class BlogControllerTest {

    @Test
    void showBlog() {
        BlogController blogController = new BlogController();

        ModelAndView modelAndView = blogController.showBlog();

        assertThat(modelAndView.getViewName()).isEqualTo("blog");//<1>
        assertThat(modelAndView.getModel()).containsKey("articles");
    }

}
// end::test[]
