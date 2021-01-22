package edu.itakademy.springdemo.model.dto;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
public class BookDTO {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private LibraryDTO library;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LibraryDTO getLibrary() {
		return library;
	}

	public void setLibrary(LibraryDTO library) {
		this.library = library;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
