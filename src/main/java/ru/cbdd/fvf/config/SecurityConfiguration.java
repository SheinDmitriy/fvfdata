package ru.cbdd.fvf.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.cbdd.fvf.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    private UserService userService;
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCustomAuthenticationSuccessHandler(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/users/**").hasRole("ADMIN")
                .antMatchers("/users/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .successHandler(customAuthenticationSuccessHandler)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/index")
                .permitAll();
    }

//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepository){
//        return new UserAuthService(userRepository);
//    }
//
//    @Autowired
//    public void authConfigure(AuthenticationManagerBuilder auth,
//                              UserDetailsService userDetailsService,
//                              PasswordEncoder passwordEncoder)  {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(passwordEncoder);
//        auth.authenticationProvider(provider);
//    }

//    @Configuration
//    @Order(1)
//    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//           http
//                   .antMatcher("/api/**")
//                   .authorizeRequests()
//                   .anyRequest()
//                   .hasAnyRole("ADMIN", "GUEST")
//                   .and()
//                   .httpBasic(Customizer.withDefaults())
//                   .csrf().disable()
//                   .sessionManagement()
//                   .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        }
//    }

//    @Configuration
//    public static class UiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
//        private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .authorizeRequests()
//                    .antMatchers("/**").permitAll()
//                    .and()
//                    .formLogin()
//                    .loginPage("/login")
//                    .loginProcessingUrl("/authenticateTheUser")
//                    .successHandler(customAuthenticationSuccessHandler)
//                    .permitAll()
//                    .and()
//                    .logout()
//                    .logoutSuccessUrl("/index")
//                    .permitAll();
//        }
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
}
