//package com.demo.security;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import com.demo.service.IUserService;
//
//@Configuration
//
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	public IUserService userService;
//	
//	
//	@Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder() ;
//        }
//	
//	
//	
////	@Bean
////	public DaoAuthenticationProvider authenticatedProvider() {
////		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
////		auth.setUserDetailsService(userService);
////		auth.setPasswordEncoder(passwordEncoder());
////		
////		
////		return null;
////		
////	}
////	
////	@Override
////	protected void configure(AuthenticationManagerBuilder authentication) throws Exception
////	{
////		authentication.authenticationProvider(authenticatedProvider());
////		
////	}
//	
//
////	@Override
////	protected void configure(HttpSecurity http) throws Exception
////	{
////		http.authorizeRequests()
////		.antMatchers("/swagger-ui.html#/")
////		.permitAll()
////		.anyRequest()
////		.authenticated()
////		.and()
////		.httpBasic();
////	}
//	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests()
//        .antMatchers("/").permitAll()
//        .antMatchers("/login").permitAll()
//        .antMatchers("/registration").permitAll()
//       ;
//	}
//	
//}
//
//
