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
    private static final String owner = "OWNER";
    private static final String chef = "CHEF";
    private static final String user = "USER";

//    specifying pwds and username for each access mode
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("owner").password(passwordEncoder().encode("owner@123")).roles(owner)
                .and()
                .withUser("chef").password(passwordEncoder().encode("chef@123")).roles(chef)
                .and()
                .withUser("user").password(passwordEncoder().encode("user")).roles(user);
    }

//    encode pwd for additional safety
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    here we limit access per user to the endpoints. Note menu is open to all
    protected void configure (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("SunnysRestaurant/owner/**").hasRole(owner)
                .antMatchers("SunnysRestaurant/chef/**").hasRole(chef)
                .antMatchers("SunnysRestaurant/user/**").hasRole(user)
                .antMatchers("SunnysRestaurant/menu").permitAll()
                .and().formLogin();
    }

}
