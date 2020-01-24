package com.example.classeetudian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/", "/home").permitAll()
//				// .anyRequest().authenticated()
//				// .anyRequest().hasRole("USER")
//				.antMatchers("/admin").hasRole("ADMIN").antMatchers("/user").hasRole("USER").antMatchers("/hello")
//				.hasAnyRole("USER", "ADMIN").and().formLogin().loginPage("/login").permitAll().and().logout()
//				.permitAll();
		http.authorizeRequests()
			.antMatchers("/", "/home")
			.permitAll()
			.antMatchers("/formEtudiant")
			.hasAnyRole("USER", "ADMIN")
			.antMatchers("/insertEtudiant")
			.hasAnyRole("USER", "ADMIN")
			.antMatchers("/user")
			.hasAnyRole("USER", "ADMIN")
			.antMatchers("/admin")
			.hasRole("ADMIN")
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN").and().withUser("user")
				.password("{noop}user").roles("USER");
	}

}
