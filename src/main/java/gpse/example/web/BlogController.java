package gpse.example.web;

import java.util.List;

import gpse.example.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(final BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping("/")
    public ModelAndView showBlog() {
        final ModelAndView modelAndView = new ModelAndView("blog");

        final List<Article> articles = blogService.getArticles(); //<2>
        modelAndView.addObject("articles", articles);

        return modelAndView;
    }

    // tag::show_form[]
    @GetMapping("/articles/add")//<1>
    public ModelAndView addArticle() {
        final ModelAndView modelAndView = new ModelAndView("article/add"); //<2>

        modelAndView.addObject("createArticleCmd", new CreateArticleCmd()); //<3>

        return modelAndView;
    }
    // end::show_form[]

    // tag::post_form[]
    @PostMapping("/articles/add")//<1>
    public ModelAndView addArticle(@AuthenticationPrincipal final User user, //<2>
                                   final CreateArticleCmd createArticleCmd) { //<3>
        blogService.addArticle(user, createArticleCmd.getTitle(), createArticleCmd.getText()); //<4>

        return new ModelAndView("redirect:/"); //<5>
    }
    // end::post_form[]

}
