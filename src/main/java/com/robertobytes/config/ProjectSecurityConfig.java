package com.robertobytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean

    /*
     * from SpringBootWebSecurityConfiguration.class (overriding defaults)
     */
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> {

            /*
             * Custom security configuration
             */
            /* Restricted */
            requests.requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated();
            /* Permitted */
            requests.requestMatchers("/contact","/notices").permitAll();

            /*
             * Deny all
             */
            // requests.anyRequest().denyAll();

            /*
             * Permit all
             */
            //requests.anyRequest().permitAll();

        });
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
