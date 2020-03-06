package gpse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("PMD.SignatureDeclareThrowsException")
// tag::class[]
@Configuration
@EnableWebSecurity //<1>
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // tag::configure[]

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        //@formatter:off
        http
            .authorizeRequests()
                .antMatchers("/", "/articles/{id:\\d+}/**")//<1>
                    .permitAll() //<2>
                .anyRequest().authenticated()
                .and()
            .formLogin()  //<3>
                .permitAll()
                .and()
            .logout()  //<4>
                .permitAll();
        //@formatter:on
    }
    // end::configure[]


    @Autowired
    public void configureGlobal(final UserDetailsService userDetailsService,  //<5>
                                final PasswordEncoder passwordEncoder,
                                final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {  //<6>
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
// tag::class[]