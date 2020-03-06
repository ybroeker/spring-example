package gpse.example.web;

import java.util.List;

import javax.validation.Valid;

import gpse.example.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

        final List<Article> articles = blogService.getArticles();
        modelAndView.addObject("articles", articles);

        return modelAndView;
    }

    // tag::single_article[]
    @RequestMapping("/articles/{id:\\d+}")// <1>
    public ModelAndView showArticle(@PathVariable("id") final String id) {// <2>
        final ModelAndView modelAndView = new ModelAndView("article/article");//<3>

        final Article article = blogService.getArticle(id);// <4>
        modelAndView.addObject("article", article);

        return modelAndView;
    }
    // end::single_article[]

    @GetMapping("/articles/add")
    public ModelAndView addArticle() {
        final ModelAndView modelAndView = new ModelAndView("article/add");

        modelAndView.addObject("createArticleCmd", new CreateArticleCmd());

        return modelAndView;
    }

    @PostMapping("/articles/add")//<1>
    public ModelAndView addArticle(@AuthenticationPrincipal final User user,
                                   @Valid final CreateArticleCmd createArticleCmd,//<1>
                                   BindingResult bindingResult) {// <2>

        if (bindingResult.hasErrors()) {// <3>
            final ModelAndView modelAndView = new ModelAndView("article/add");// <4>
            modelAndView.addObject("createArticleCmd", createArticleCmd);// <5>
            return modelAndView;
        }

        blogService.addArticle(user, createArticleCmd.getTitle(), createArticleCmd.getText());

        return new ModelAndView("redirect:/");
    }

}
