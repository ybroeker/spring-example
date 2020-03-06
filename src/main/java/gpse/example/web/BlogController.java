package gpse.example.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import gpse.example.domain.*;

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
    @RequestMapping("/articles/{id:\\d+}")
    public ModelAndView showArticle(@PathVariable("id") String id) {
        final ModelAndView modelAndView = new ModelAndView("article/article");

        final Article article = blogService.getArticle(id);
        modelAndView.addObject("article", article);
        modelAndView.addObject("addCommentCmd", new AddCommentCmd());// <1>

        return modelAndView;
    }
    // end::single_article[]

    // tag::add_comment[]
    @PostMapping("/articles/{id:\\d+}/comments")// <1>
    public ModelAndView addComment(@PathVariable("id") String id,
                                   @Valid final AddCommentCmd addCommentCmd,
                                   BindingResult bindingResult) {//<2>

        if (!bindingResult.hasErrors()) {// <3>
            final Article saved = blogService.addComment(id, addCommentCmd.getText());//<4>
        }

        return new ModelAndView("redirect:/articles/" + id);//<5>
    }
    // end::add_comment[]

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
