package com.demo.springdemoproject;

import com.demo.springdemoproject.model.Users;
import com.demo.springdemoproject.repository.UserJPARepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SpringDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoProjectApplication.class, args);
	}
	@Bean
	CommandLineRunner init(UserJPARepository userRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				Users user = new Users();
				user.setName(name);
				user.setTeamname("NGProc");
				user.setSalary(1000);
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}

}
