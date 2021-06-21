package curso.cap.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import curso.cap.springboot.servicios.UserDetailCursoService;
import lombok.Data;

@Configuration
@Data
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailCursoService service;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		
		http.formLogin().loginPage("/login");
		http.formLogin().loginProcessingUrl("/autenticar");
		http.formLogin().usernameParameter("usuario");
		http.formLogin().passwordParameter("clave");
		http.formLogin().defaultSuccessUrl("/");
		http.formLogin().failureUrl("/login?error=usuario o clave no validos");
		http.logout().logoutSuccessUrl("/login?logout=true");
		http.csrf().disable();
		http.cors();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(getService()).passwordEncoder(new BCryptPasswordEncoder(4));
	}

}










