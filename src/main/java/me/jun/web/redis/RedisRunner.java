package me.jun.web.redis;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;



@Component
public class RedisRunner implements ApplicationRunner{

	@Autowired
	StringRedisTemplate redisTemplate;
	
	@Autowired
	RedisAccountRepository redisRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		ValueOperations<String, String> values = redisTemplate.opsForValue();
		values.set("jun", "izic");
		values.set("springboot", "2.0.0");
		values.set("hello","world");
		values.set("haha", "hoho");
		
		RedisAccount redisAccount = new RedisAccount()
										.setEmail("wnsaud6016@naver.com")
										.setUsername("junmyoung");
		
		redisRepository.save(redisAccount);
		
		Optional<RedisAccount> byId = redisRepository.findById(redisAccount.getId());
		System.out.println(byId.get().getUsername());
		System.out.println(byId.get().getEmail());
		
		
		
	}

}
