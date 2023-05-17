package com.demo.springdemoproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springdemoproject.model.Users;
import com.demo.springdemoproject.repository.UserJPARepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserJPARepository userJPArepository;
	
	@PostMapping(value="/load")
	public Users load(@RequestBody final Users user)
	{
		userJPArepository.save(user);
		// to check whether the particular data got inserted or not
		return userJPArepository.findByName(user.getName());
		//it is function under optional object which states if the value is present or not -> Nosuchelementexception
		//userJPArepository.findByID(user.getID()).get();
	}
	
	
	//@RequestMapping(value="/all", method = RequestMethod.GET)
	@GetMapping(value= "/all")	// this can be used instead of line given above 
	public List<Users> findAll()
	{
		return userJPArepository.findAll();
	}
	
	@GetMapping(value= "name/{name}")
	public Users findByName(@PathVariable final String name)
	{
		return userJPArepository.findByName(name);
	}
	
	@GetMapping(value= "id/{id}")
	public Optional<Users> findById(@PathVariable final Long id)//Pathvariable is used to handle template variable in request URI mapping
	{
		return userJPArepository.findById(id);
	}
	
	@GetMapping(value= "message")
	public String getApplicationMessage()
	{
		return "This application returns user details!!";
	}
	
	@GetMapping(value="/add/{n1}/{n2}")	//this will return addition of number
	public Integer addition(@PathVariable String n1,@PathVariable String n2)
	{
		return Integer.parseInt(n1)+Integer.parseInt(n2);
	}
	
}
