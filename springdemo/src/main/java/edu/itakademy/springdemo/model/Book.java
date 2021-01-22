package edu.itakademy.springdemo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Book {
	
	private final static Logger log = LoggerFactory.getLogger(Book.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
    @JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "library_id")
	private Library library;
	
	public Book() {
	}
	
	public Book(String name) {
		this.name = name;
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

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", library=" + library + "]";
	}
	
	@PrePersist
	public void logNewBookAttempt() {
	    log.info("Attempting to add new book with name: " + name);
	}
	    
	@PostPersist
	public void logNewBookAdded() {
	    log.info("Added book '" + name + "' with ID: " + id);
	}
	    
	@PreRemove
	public void logBookRemovalAttempt() {
	    log.info("Attempting to delete book: " + name);
	}
	    
	@PostRemove
	public void logBookRemoval() {
	    log.info("Deleted book: " + name);
	}

	@PreUpdate
	public void logBookUpdateAttempt() {
	    log.info("Attempting to update book: " + name);
	}

	@PostUpdate
	public void logBookUpdate() {
	    log.info("Updated book: " + name);
	}

	@PostLoad
	public void logBookLoad() {
	    name = name + " N°1";
	    log.info("Loaded book: " + name);
	}

}
