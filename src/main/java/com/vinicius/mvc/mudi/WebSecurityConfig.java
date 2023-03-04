package com.vinicius.mvc.mudi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests((requests) -> requests
                                                .requestMatchers("/home/**")
                                                .permitAll()
                                                .anyRequest()
                                                .authenticated())
                                .formLogin((form) -> form
                                                .loginPage("/login")
                                                .permitAll()
                                                .defaultSuccessUrl("/usuario/pedido"))
                                .logout((logout) -> logout
                                                .permitAll()
                                                .logoutSuccessUrl("/home"))
                                .csrf().disable();

                return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public UserDetailsManager users(DataSource dataSource) {
                JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
                return users;
        }

}
