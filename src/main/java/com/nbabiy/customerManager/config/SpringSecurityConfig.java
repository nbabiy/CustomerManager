package com.nbabiy.customerManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author nazariibabii
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    static public final String ROLE_USER = "ROLE_USER";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
            .inMemoryAuthentication()
                .withUser("buzz")
                    .password(passwordEncoder().encode("infinity"))
                    .authorities(ROLE_USER)
                .and()
                .withUser("woody")
                    .password(passwordEncoder().encode("bullseye"))
                    .authorities(ROLE_USER);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
