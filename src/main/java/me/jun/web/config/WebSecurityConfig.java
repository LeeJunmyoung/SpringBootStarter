package me.jun.web.config;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import me.jun.web.account.Account;
import me.jun.web.account.AccountRepository;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements UserDetailsService {

	@Autowired
	AccountRepository accountRepository;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
			.antMatchers("/","/helloworld").permitAll()
			.anyRequest().authenticated()
			.and()
		   .formLogin()
		   	.and()
		   .httpBasic();
			
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Account> byUsername = accountRepository.findByUsername("junmyoung");
		Account account = byUsername.orElseThrow(()-> new UsernameNotFoundException(username));
		
		return new User(account.getUsername(),account.getPassword(),authrities());
	}

	private Collection<? extends GrantedAuthority> authrities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//return NoOpPasswordEncoder.getInstance();
	}

}
