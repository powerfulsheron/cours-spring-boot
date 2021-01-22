package edu.itakademy.springdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.itakademy.springdemo.model.Book;
import edu.itakademy.springdemo.model.Library;

public interface LibraryRepository {
	
    Library getLibraryById(Integer id);

	List<Library> getAllLibraries();

	void save(Library library);

//	void update(Library library, String[] params);

	void delete(Library library);

	void update(Library library);
    
}
