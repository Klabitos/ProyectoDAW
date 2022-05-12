package com.klabitos.app.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * The Class ConfiguracionSeguridadColegio.
 */
@Configuration
@EnableWebSecurity(debug=true)
public class ConfiguracionSeguridadColegio extends WebSecurityConfigurerAdapter{
	
	/** The data source. */
	@Autowired
	DataSource dataSource;
	
	/** The password encoder. */
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * Config authentication.
	 *
	 * @param auth the auth
	 * @throws Exception the exception
	 */
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
	} 
	
	/**
	 * Configure.
	 *
	 * @param web the web
	 * @throws Exception the exception
	 */
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/resources**"); 
	}
	
	/**
	 * Configure.
	 *
	 * @param http the http
	 * @throws Exception the exception
	 */
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/v1/usuarios").permitAll()
		.antMatchers("/v1/security/authority").permitAll()
		.antMatchers("/v1/security/user").permitAll()
		.antMatchers("/v1/ropausuarios").permitAll()
		.antMatchers("/v1/ropas").permitAll()
		.antMatchers("/v1/username").permitAll()
        .antMatchers("/v1/username/active").hasAnyRole("USER", "ADMIN")
		.antMatchers("/v1/conjuntos").hasAnyRole("USER", "ADMIN")
		.antMatchers("/v1/usuarios/nickname").hasAnyRole("USER", "ADMIN")
		.antMatchers("/v1/ropatipos").hasAnyRole("USER", "ADMIN")
        .antMatchers("/v1/security/authority/isAdmin/").hasRole("ADMIN")
		.and()
		.formLogin()
		.loginPage("http://localhost:8081/") 
	    .usernameParameter("username")
	    .passwordParameter("password")
			.loginProcessingUrl("/login")
	    .defaultSuccessUrl("http://localhost:8081/", true) 
	    .failureUrl("http://localhost:8081/?error=true")
		.and().logout().logoutUrl("/logout").deleteCookies("JSESSIONID");
		
		
		http.csrf().disable(); 
	}
	
	

}



