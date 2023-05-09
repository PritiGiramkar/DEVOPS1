package com.demo.springdemoproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.springdemoproject.model.Users;

@Component //it configures the below class as bean
@Repository // it configures that below class has connection to database
// Jparespository is interface which consists of by default crud operations 
public interface UserJPARepository extends JpaRepository<Users, Long>{

	
	Users findByName(String name);

	Optional<Users> findById(Long id);



	//Users findById(String id);
}
