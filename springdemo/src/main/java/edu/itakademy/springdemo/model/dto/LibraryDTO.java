package edu.itakademy.springdemo.model.dto;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
public class LibraryDTO {

	private Integer id;
	
	private String name;
	
	public LibraryDTO() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}