package edu.itakademy.springdemo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.itakademy.springdemo.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query("SELECT u FROM Book u WHERE u.name = 'Grey Wolf'")
	List<Book> findAllBooksWhereNameIs();
	
	List<Book> findByLibraryIsNull();

}
