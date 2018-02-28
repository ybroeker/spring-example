package gpse.example.web;

import java.util.ArrayList;

import gpse.example.domain.Article;
import gpse.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// tag::class[]
@Controller//<1>
public class BlogController {

    @RequestMapping("/")//<2>
    public ModelAndView showBlog() {
        var modelAndView = new ModelAndView("blog");//<3>

        User user = new User("Uncle Bob", "Bob", "Martin");

        var articles = new ArrayList<>();//<4>
        articles.add( new Article(user, "A magnificent Article", "Lorem ipsum dolor"));
        articles.add( new Article(user, "Another Article", "sit amet, consetetur sadipscing elitr"));

        modelAndView.addObject("articles", articles);//<5>

        return modelAndView;
    }
}
// end::class[]
