package tdpe.example;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// tag::class[]
@Controller //<1>
public class WelcomeController {

    @Value("${application.message:Hello World}") //<3>
    private String message = "Hello World";

    @RequestMapping("/") //<2>
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("time", LocalDateTime.now());
        modelAndView.addObject("message", this.message);

        return modelAndView;
    }

}
// end::class[]
