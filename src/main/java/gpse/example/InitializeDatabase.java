package gpse.example;

// tag::class[]

import gpse.example.domain.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class InitializeDatabase implements InitializingBean {

    private final UserService userService;

    private final BlogService blogService;

    @Autowired
    public InitializeDatabase(final UserService userService, final BlogService blogService) {
        this.userService = userService;
        this.blogService = blogService;
    }


    @Override
    public void afterPropertiesSet() {
        try {
            userService.loadUserByUsername("Uncle_Bob");// <1>
        } catch (UsernameNotFoundException ex) {
            final User user = userService.createUser("Uncle_Bob",//<2>
            "{bcrypt}$2a$10$WoG5Z4YN9Z37EWyNCkltyeFr6PtrSXSLMeFWOeDUwcanht5CIJgPa",
            "Bob", "Martin", "ROLE_USER");

            blogService.addArticle(user, "A magnificent Article", "Lorem ipsum dolor");
            blogService.addArticle(user, "Another Article", "sit amet, consetetur sadipscing elitr");// <3>
        }
    }
}
// end::class[]
