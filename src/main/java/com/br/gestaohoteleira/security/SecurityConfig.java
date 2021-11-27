package com.br.gestaohoteleira.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * @author Vinícius
     * @see BCryptPasswordEncoder
     * @apiNote Encoder do password
     * */

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * apiNote Qualquer requisicao http irá para o método formLogin()
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
        .antMatchers("/css/*.css", "/js/*.js", "/img/*.jpg", "/img/*.png").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login")
        .defaultSuccessUrl("/user", true)
        .permitAll()
        .and()  // this is for the logout   
        .logout()
        .invalidateHttpSession(true)
        .logoutUrl("/logout")
        .permitAll();
    }

    /**
     * apiNote Qualquer requisicao http irá para o método formLogin()
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("recepcionista")
                .password(passwordEncoder().encode("12345")).authorities("REC")
                .and().withUser("administrador")
                .password(passwordEncoder().encode("12345")).authorities("ADM")
                .and().withUser("gerente")
                .password(passwordEncoder().encode("12345")).authorities("GER");
    }
}