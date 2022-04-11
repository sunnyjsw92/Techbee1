package com.sj.SunnyRestaurant1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /*3 types of users defined - owner that can do CRUD on menu, chef can view orders,
        user that can do CRUD on orders and menu that is open to all*/
    private static final String ROLE_1 = "OWNER";
    private static final String ROLE_2 = "CHEF";
    private static final String ROLE_3 = "USER";

    //    specifying pwds and username for each access mode
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("owner").password(passwordEncoder().encode("owner@123")).roles(ROLE_1)
                .and()
                .withUser("chef").password(passwordEncoder().encode("chef@123")).roles(ROLE_2)
                .and()
                .withUser("user").password(passwordEncoder().encode("user")).roles(ROLE_3);
    }

    //    encode pwd for additional safety
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    here we limit access per user to the endpoints. Note menu is open to all. Added test just for
    //    testing
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().csrf().disable()
                .authorizeRequests().mvcMatchers("/SunnysRestaurant/owner/**").hasRole(ROLE_1)
                .mvcMatchers("/SunnysRestaurant/chef/**").hasRole(ROLE_2)
                .mvcMatchers("/SunnysRestaurant/user/**").hasRole(ROLE_3)
                .mvcMatchers("/SunnysRestaurant/menu").permitAll()
                .mvcMatchers("/SunnysRestaurant/test").permitAll()
                .and().formLogin();
    }
}
