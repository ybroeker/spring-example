package gpse.example.web;

import java.util.ArrayList;
import java.util.List;

import gpse.example.domain.Article;
import gpse.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tdpe.example.domain.Article;
import gpse.example.domain.BlogService;

// tag::class[]
@Controller
public class BlogController {

    private BlogService blogService;

    @Autowired //<1>
    public BlogController(BlogService blogService) {
        this.blogService=blogService;
    }

    @RequestMapping("/")
    public ModelAndView showBlog() {
        ModelAndView modelAndView = new ModelAndView("blog");

        List<Article> articles = blogService.getArticles(); //<2>
        modelAndView.addObject("articles", articles);

        return modelAndView;
    }
}
// end::class[]
