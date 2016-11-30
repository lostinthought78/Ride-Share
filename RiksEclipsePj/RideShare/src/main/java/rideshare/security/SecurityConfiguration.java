package rideshare.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import rideshare.service.UserService;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

			http.authorizeRequests()
					.antMatchers("/is-user-logged-in", 
								 "/login/**",
								 "/register/**")
						.permitAll()
					.anyRequest()
						.authenticated()
				.and()
					.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/map/")
					.permitAll()
				.and()
					.logout()
					.permitAll()
				.and()
					.sessionManagement()
						.sessionFixation()
						.changeSessionId();
	}
	
	 @Bean 
	 public PasswordEncoder passwordEncoder(){
		 return new BCryptPasswordEncoder();
	 }
}