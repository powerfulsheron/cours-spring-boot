package edu.itakademy.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.itakademy.demo.entity.Book;
import edu.itakademy.demo.entity.dto.BookDTO;
import edu.itakademy.demo.repository.BookRepositoryInterface;
import edu.itakademy.demo.service.BookServiceInterface;
import edu.itakademy.demo.service.MailService;

@Service
public class BookServiceImpl implements BookServiceInterface {
	
	@Autowired
	private BookRepositoryInterface bookRepositoryInterface;
	
	@Autowired
	private MailService mailService;

	@Override
	public Book getBook(Integer id) {
		
		return this.bookRepositoryInterface.findById(id).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
			);
				
		//return this.bookRepositoryInterface.getBookById(id);
	}

	@Override
	public List<Book> getBooks() {
		return this.bookRepositoryInterface.findAll();
		//return this.bookRepositoryInterface.getBooks(); 
	}
	
	@Override
	public List<Book> getAllBooksWhereNameIs() {
		return this.bookRepositoryInterface.findAllBooksWhereNameIs("Grey Wolf");
	}
	
	@Override
	public List<Book> getAllBooksWithoutDescription() {
		return this.bookRepositoryInterface.findByDescriptionIsNull();
		//return this.bookRepositoryInterface.findAllBooksWhereNameIs("Grey Wolf");
	}


	@Override
	public void deleteBook(Integer id) {
		this.bookRepositoryInterface.deleteById(id);
		//Book book = this.bookRepositoryInterface.getBookById(id);
		//this.bookRepositoryInterface.delete(book);
	}

	@Override
	public void saveBook(Book book) {
		this.bookRepositoryInterface.save(book);
		this.mailService.sendSimpleMessage(book);
	}

	@Override
	public Book updateBook(Integer id, BookDTO bookDTO) {
		Book book = mapToEntity(bookDTO, this.getBook(id));
		return this.bookRepositoryInterface.save(book); 
		//this.bookRepositoryInterface.update(book);
		//return book;
	}
	
	private Book mapToEntity(BookDTO bookDTO, Book book) {
		book.setName(bookDTO.getName());
		book.setDescription(bookDTO.getDescription());
		return book;
	}

}
