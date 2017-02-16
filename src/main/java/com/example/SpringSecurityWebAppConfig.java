package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static com.stormpath.spring.config.StormpathWebSecurityConfigurer.stormpath;

/**
 * @author Joe Kutner on 2/16/17.
 *         Twitter: @codefinger
 */
@Configuration
public class SpringSecurityWebAppConfig extends WebSecurityConfigurerAdapter {

  /**
   * {@inheritDoc}
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.apply(stormpath()).and()
        .authorizeRequests()
        .antMatchers("/").permitAll();
  }
}
