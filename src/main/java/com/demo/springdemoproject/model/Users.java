package com.demo.springdemoproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	private long id;
	private String name;
	private String teamname;
	private Integer salary;
	
	@Id	// this is primary key
	@GeneratedValue(strategy = GenerationType.AUTO)		//it will y default add the id to the value
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getSalary() {
		return salary;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

}
