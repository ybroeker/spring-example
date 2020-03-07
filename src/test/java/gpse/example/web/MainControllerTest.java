package gpse.example.web;

import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;

class MainControllerTest {

    @Test
    void showBlog() {
        MainController controller = new MainController();

        ModelAndView modelAndView = controller.getIndex();

        assertThat(modelAndView.getViewName()).isEqualTo("index");
    }

}
