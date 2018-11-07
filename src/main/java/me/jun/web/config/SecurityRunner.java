package me.jun.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import me.jun.web.account.Account;
import me.jun.web.account.AccountRepository;

@Component
public class SecurityRunner implements ApplicationRunner {

	@Autowired
	AccountRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		String pw = encoder.encode("1234");
		System.out.println(pw);
		Account account = new Account().setUsername("junmyoung")
				     				   .setPassword(pw);
		
		System.out.println(repo.save(account));
		
		
	}

}
