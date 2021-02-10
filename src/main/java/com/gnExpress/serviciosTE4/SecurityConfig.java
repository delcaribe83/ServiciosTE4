package com.gnExpress.serviciosTE4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gnExpress.serviciosTE4.services.UserServices;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserServices userDetailsServices;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		
		return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsServices).passwordEncoder(bCrypt);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
				
		http.authorizeRequests()
		.antMatchers("/", "/gnExpress/**", "/css/**", "/font/**", "/img/**", "/js/**")
		.permitAll().anyRequest()
		.authenticated()  //Aquí ponemos las url que van a ser de dominio público (permitAll() "para permitirlo" y anyRequest().authenticated() para cualquier otra peticion que sea autenticada, que necesite una auenticación)
		.and()   // a través del método and() podemo concatenar métodos
		.formLogin()
		.loginPage("/gnExpress/login")
		.defaultSuccessUrl("/private/admin", true)
		.failureUrl("/gnExpress/login?error=true")
		
		.//Puedo utilizar el método formLogin() para indicarle cual es el formulario que voy a utilizar, de esta manera podría personalizar el formulario de login y le indico la url que desplegaría este formulario en caso de entrar (defaultSuccessUrl("/private/admin", true)) y la url en caso de no autenticar (failureUrl("/auth/login?error=true"), el ?error lo maneja Spring internamente)
		loginProcessingUrl("/gnExpress/login-post").permitAll()   // Le decimos en qué método post del controller se va a procesar este login (loginProcessingUrl("/auth/login-post")) y le decimos que lo permita (permitAll())......Para que se entienda, es la direccion que va a utilizar el form del loguin en el action="" para enviar los datos de login, luego Spring se encarga de lo demás
		.and()
		.rememberMe()
		.and()	
	 	.logout().logoutUrl("/logout").logoutSuccessUrl("/public/index");


		
	}
	

}
