package gpse.example.web;
// tag::test[]

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;
import tdpe.example.domain.BlogService;

import static org.assertj.core.api.Assertions.assertThat;

class BlogControllerTest {


    @Mock //<1>
    private BlogService blogService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);//<2>
    }

    @Test
    void showBlog() {
        BlogController blogController = new BlogController(blogService);//<3>

        ModelAndView modelAndView = blogController.showBlog();

        assertThat(modelAndView.getViewName()).isEqualTo("blog");
        assertThat(modelAndView.getModel()).containsKey("articles");
    }

}
// end::test[]
