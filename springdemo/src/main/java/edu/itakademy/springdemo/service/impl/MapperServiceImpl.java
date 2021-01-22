package edu.itakademy.springdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.itakademy.springdemo.model.Book;
import edu.itakademy.springdemo.model.Library;
import edu.itakademy.springdemo.model.dto.BookDTO;
import edu.itakademy.springdemo.model.dto.LibraryDTO;
import edu.itakademy.springdemo.service.LibraryService;
import edu.itakademy.springdemo.service.MapperServiceInterface;


@Service
public class MapperServiceImpl implements MapperServiceInterface {
	
	@Autowired
	private LibraryService libraryService;
	
	@Override
    public Book mapBookDTOToEntity(BookDTO bookDTO, Book book) {
    	book.setName(bookDTO.getName());
    	book.setLibrary(this.libraryService.getLibrary(bookDTO.getLibrary().getId()));
        return book;
    }

	@Override
    public BookDTO mapBookEntityToDTO(BookDTO bookDTO, Book book) {
    	bookDTO.setName(book.getName());
    	bookDTO.setLibrary(mapLibraryEntityToDTO(new LibraryDTO(), book.getLibrary()));
        return bookDTO;
    }
    
	@Override
    public LibraryDTO mapLibraryEntityToDTO(LibraryDTO libraryDTO, Library library) {
    	libraryDTO.setId(library.getId());
    	libraryDTO.setName(library.getName());
        return libraryDTO;
    }
	
}
