package edu.itakademy.springdemo.controller;
import org.springframework.http.HttpStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.itakademy.springdemo.model.Library;
import edu.itakademy.springdemo.model.dto.LibraryDTO;
import edu.itakademy.springdemo.service.LibraryService;

@RestController
@RequestMapping(value = "/api/library", produces = MediaType.APPLICATION_JSON_VALUE)
public class LibraryController {
	
	@Autowired
	LibraryService libraryService;
	
    @GetMapping()
    public List<Library> getAllLibraries() {
    	System.out.println(libraryService.getAllLibraries());
    	return libraryService.getAllLibraries();
    }
    
    @GetMapping("/{id}")
    public Library getLibrary(@PathVariable Integer id) {
    	return libraryService.getLibrary(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Library createLibrary(@RequestBody Library library) {
    	this.libraryService.saveLibrary(library);
    	return library;
    }
    
    @PutMapping("/{id}")
    public Library updateLibrary(@PathVariable Integer id, @RequestBody LibraryDTO libraryDTO) {
    	return this.libraryService.updateLibrary(id, libraryDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLibrary(@PathVariable Integer id) {
    	libraryService.delete(id);
    }
    
}
