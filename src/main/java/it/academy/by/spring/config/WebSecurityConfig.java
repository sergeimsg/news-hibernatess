package it.academy.by.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService;
  
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  
	  
	  CharacterEncodingFilter filter = new CharacterEncodingFilter();
	  filter.setEncoding("UTF-8");
	  filter.setForceEncoding(true);
	  http.addFilterBefore(filter, CsrfFilter.class);
	  
    http.authorizeRequests()
    .antMatchers("/news/admin/**").hasRole("ADMIN")
    .antMatchers("/news/goToBasePage**","/user/**", "/news/errorPage", "/error", "/news/changeLocale").permitAll()
    .antMatchers("/news/**").authenticated()
    
    .and()
    .exceptionHandling()
    .accessDeniedPage("/user/access-denied")
    
    .and()
    .formLogin()
    .loginPage("/news/goToBasePage")
    
    .loginProcessingUrl("/user/loginAction")
    .successForwardUrl("/user/loginAction")
    .failureUrl("/news/goToBasePage?error")        
    
    .and()
    .logout().logoutUrl("/logout").logoutSuccessUrl("/news/goToBasePage")
    
    .and()
    .csrf().disable();
  }
}
