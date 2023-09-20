package net.gandra404.demojosh.springauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
public class SpringAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthServerApplication.class, args);
	}

	@Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		UserDetails gandra = User.withDefaultPasswordEncoder().roles("user").username("gandra").password("1234").build();
		UserDetails admin = User.withDefaultPasswordEncoder().roles("admin").username("admin").password("1234").build();
		return new InMemoryUserDetailsManager(gandra, admin);
	}
}


