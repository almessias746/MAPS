package com.maps.finances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        http
         .csrf().disable()
         .authorizeRequests().anyRequest().hasAnyRole("USER","ADMIN")
         .and()
         .httpBasic();
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
            throws Exception 
    {
    	auth.inMemoryAuthentication()
        .withUser("root")
        .password("spiderman")
        .roles("ADMIN");
    	
    	for (int i = 0; i < 10; i++) {
    		auth.inMemoryAuthentication()
            .withUser("usuario"+i)
            .password("senha"+i)
            .roles("USER");	
    	}
    	
    }
}