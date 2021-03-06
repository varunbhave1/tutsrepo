package com.udemy.app.ws.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.udemy.app.ws.service.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{


	private final UserService userService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public WebSecurity(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
	
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity httpsec) throws Exception {
		
		/*httpsec.csrf().disable().authorizeRequests().
		antMatchers(HttpMethod.POST,SecurityConstants.SIGN_UP_URL).permitAll().
		anyRequest().authenticated();
		*/
		
		httpsec.csrf().disable().authorizeRequests().
		antMatchers(HttpMethod.POST,SecurityConstants.SIGN_UP_URL)
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.addFilter(new AuthenticationFilter(authenticationManager()))
		.addFilter(new AuthorizationFilter(authenticationManager()))
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	public AuthenticationFilter getAuthenticationFilter() throws Exception{
	
		final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/users/login");
		return filter;
		
	}
	
	
	
}
