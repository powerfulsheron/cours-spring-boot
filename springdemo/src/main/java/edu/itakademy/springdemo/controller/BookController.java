package edu.itakademy.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import edu.itakademy.springdemo.model.Book;
import edu.itakademy.springdemo.model.dto.BookDTO;
import edu.itakademy.springdemo.service.BookService;

@RestController
@RequestMapping(value = "/api/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
	
	@Autowired
	BookService bookService;
	
    @GetMapping()
    public List<Book> getBooks() {
    	return bookService.getAllBooks();
    }
    
    @GetMapping("/sorted")
    public List<Book> getSortedBooks() {
    	return bookService.getAllBooksSorted();
    }
    
    @GetMapping("/nameis")
    public List<Book> getdBooksWhereNameIs() {
    	return bookService.getAllBooksWhereNameIs();
    }
    
    @GetMapping("/librarynull")
    public List<Book> getdBooksWhereLibraryNull() {
    	return bookService.getAllBooksWithNullLibrary();
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable Integer id) {
    	return bookService.getBook(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
    	return this.bookService.save(bookDTO);
    }
    
    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
    	return this.bookService.update(id, bookDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id) {
    	bookService.delete(id);
    }

}
