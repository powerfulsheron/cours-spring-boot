package edu.itakademy.springdemo.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import edu.itakademy.springdemo.model.Book;
import edu.itakademy.springdemo.model.Library;
import edu.itakademy.springdemo.model.dto.BookDTO;
import edu.itakademy.springdemo.model.dto.LibraryDTO;
import edu.itakademy.springdemo.repository.BookRepository;
import edu.itakademy.springdemo.repository.LibraryRepository;
import edu.itakademy.springdemo.service.BookService;
import edu.itakademy.springdemo.service.LibraryService;
import edu.itakademy.springdemo.service.MapperServiceInterface;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private MapperServiceInterface mapperServiceInterface;
	
//	@Autowired
//	private JavaMailSender emailSender;

	@Override
	public BookDTO getBook(Integer id) {
		Book book = this.bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return mapperServiceInterface.mapBookEntityToDTO(new BookDTO(), book);
	}

	@Override
	public List<Book> getAllBooksSorted() {
		return this.bookRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}
	
	@Override
	public List<Book> getAllBooksWhereNameIs() {
		return this.bookRepository.findAllBooksWhereNameIs();
	}
	
	@Override
	public List<Book> getAllBooksWithNullLibrary() {
		return this.bookRepository.findByLibraryIsNull();
	}
	
	@Override
	public List<Book> getAllBooks() {
		return this.bookRepository.findAll();
	}

	@Override
	public BookDTO save(BookDTO bookDTO) {
		Book book = mapperServiceInterface.mapBookDTOToEntity(bookDTO, new Book());
		this.bookRepository.save(book);
		return mapperServiceInterface.mapBookEntityToDTO(bookDTO, book);
	}

	@Override
	public void delete(Integer id) {
		this.bookRepository.deleteById(id); ;
	}
	
	public BookDTO update(Integer id, BookDTO bookDTO) {
		Book book = this.bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		book = this.mapperServiceInterface.mapBookDTOToEntity(bookDTO, book);
		this.bookRepository.save(book);
		bookDTO.setId(book.getId());
		return bookDTO;
	}
	
//    private void sendSimpleMessage() {
//        SimpleMailMessage message = new SimpleMailMessage(); 
//        message.setFrom("itakademytestspring@gmail.com");
//        message.setTo("lcanavaggio@wedigital.garden");
//        message.setSubject("Nouveau livre ajouté"); 
//        message.setText("Un nouveau livre à été ajouté benks");
//        emailSender.send(message);
//    }

}
