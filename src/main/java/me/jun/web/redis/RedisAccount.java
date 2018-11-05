package me.jun.web.redis;

import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("redisAccount")
public class RedisAccount {

	@Id
	private String id;
	
	private String username;
	
	private String email;

	public String getId() {
		return id;
	}

	public RedisAccount setId(String id) {
		this.id = id;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public RedisAccount setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public RedisAccount setEmail(String email) {
		this.email = email;
		return this;
	}
	
	
	
}
