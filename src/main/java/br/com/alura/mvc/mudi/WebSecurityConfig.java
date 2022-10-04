package br.com.alura.mvc.mudi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/usuario/pedido", true)
                        .permitAll()
                )
                .logout(logout -> logout.logoutUrl("/logout"))
                .csrf().disable();

        return http.build();
    }

    @Bean
    UserDetailsManager users(DataSource dataSource) {
        UserDetails admin = User.builder()
                .username("citnes")
                .password(passwordEncoder().encode("delta"))
                .roles("USER", "ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("celisa")
                .password(passwordEncoder().encode("maria"))
                .roles("USER")
                .build();

        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(admin);
//        users.createUser(user);
        return users;
    }
}
