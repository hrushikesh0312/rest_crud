package com.cybage.pms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


	
	
	@Configuration
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("user")
					.password("user123").roles("USER").and().withUser("admin").password("admin123").roles("ADMIN");
		// this is for in memory authentication means data we provide
			
		}

		@Bean  // this is depricated i.e the return type hence we provoded a new BCrypt pass encoder obj
		public PasswordEncoder getPasswordEncoder()
		{
			return NoOpPasswordEncoder.getInstance(); 
		}
		
		
//		@Bean // this method is giving error not supported try using above method  only 
//		public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//		}
//		
		// secure the endpoints using http security basic configuration
		@Override
		protected void configure(HttpSecurity http) throws Exception {


		//HTTP Basic authentication
		http.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/getAllProducts").hasRole("USER")
		.antMatchers(HttpMethod.POST, "/addProduct").hasRole("ADMIN")
		// .antMatchers(HttpMethod.PUT, "/getProduct/**").hasRole("ADMIN")
		// .antMatchers(HttpMethod.PATCH, "/books/**").hasRole("ADMIN")
		// .antMatchers(HttpMethod.DELETE, "/books/**").hasRole("ADMIN")
		.and()
		.csrf().disable()
		.formLogin().disable();
		// we can access link get all prod directly as we allowed to access add prod cant be accessed bcoz we are alloeing to access it by admin
       // in postman open authorization tab basic auth and provide details to check
		}
	}//hen we access add prod using user login it will give error as we provided security

// this class provides configuration for spring framework password encoder method provides encoding for the pswd otherwise it will thorw an exception

 