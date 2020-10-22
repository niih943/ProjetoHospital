package com.sistemaHospital.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests()
				.antMatchers("/*").permitAll() 
				.antMatchers("/user/**").hasRole("USUARIO")
				.antMatchers("/ava/**").hasRole("AVALIADOR")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest()
				.authenticated()
			.and()
			.formLogin()
				.loginPage("/areaAcesso")
				.defaultSuccessUrl("/")
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/areaAcesso?logout")
				.permitAll();
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
    
	
}
