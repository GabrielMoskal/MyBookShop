package app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Gabriel on 20.03.2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .anyRequest().permitAll()
                .and()
                .formLogin()
                    .loginPage("/users/login")
                    .permitAll()
                .and()
                .logout()
                    .logoutSuccessUrl("/login?logout")
                .and()
                .rememberMe()
                    .tokenValiditySeconds(3600)
                    .key("rememberKey")
                .and()
                .httpBasic()
                    .realmName("MyWebApp");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        // TODO
    }
}
