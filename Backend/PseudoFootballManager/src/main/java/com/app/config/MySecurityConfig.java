package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.app.service.CustomUserServiceImpl;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private CustomUserServiceImpl customuserDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	 @Override
	protected void configure(HttpSecurity http) throws Exception {
		 System.out.println("Request Raised To Server");
	        http.cors().and().csrf().disable().authorizeRequests()
	                .antMatchers(HttpMethod.POST, "/user/login").permitAll()
	                .antMatchers(HttpMethod.POST, "/user/registerPlayer").permitAll()
	                .antMatchers(HttpMethod.POST, "/user/registerManager").permitAll()
	                .antMatchers(HttpMethod.POST, "/user/register").permitAll()
	                .antMatchers(HttpMethod.GET, "/home/get-teams").permitAll()
	                .antMatchers(HttpMethod.GET, "/home/get-liveMatches").permitAll()
	                .antMatchers(HttpMethod.GET, "/home/get-featuredMatches").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);   
	        http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
	    }
	
	 @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	         auth.userDetailsService(customuserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	    }
	
	 @Bean 
	 public AuthenticationManager authenticationManagerBean()throws Exception {
		 return super.authenticationManagerBean();		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
