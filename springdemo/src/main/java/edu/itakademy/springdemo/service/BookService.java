package edu.itakademy.springdemo.service;

import java.util.List;
import java.util.Optional;

import edu.itakademy.springdemo.model.Book;
import edu.itakademy.springdemo.model.Library;
import edu.itakademy.springdemo.model.dto.BookDTO;
import edu.itakademy.springdemo.model.dto.LibraryDTO;

public interface BookService {

	BookDTO getBook(Integer id);

	List<Book> getAllBooks();

	BookDTO save(BookDTO bookDTO);

	void delete(Integer id);

	BookDTO update(Integer integer, BookDTO bookDTO);

	List<Book> getAllBooksSorted();

	List<Book> getAllBooksWhereNameIs();

	List<Book> getAllBooksWithNullLibrary();
	
}
