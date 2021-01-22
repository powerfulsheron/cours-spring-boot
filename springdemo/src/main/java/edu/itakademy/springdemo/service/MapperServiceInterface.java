package edu.itakademy.springdemo.service;

import edu.itakademy.springdemo.model.Book;
import edu.itakademy.springdemo.model.Library;
import edu.itakademy.springdemo.model.dto.BookDTO;
import edu.itakademy.springdemo.model.dto.LibraryDTO;

public interface MapperServiceInterface {

	Book mapBookDTOToEntity(BookDTO bookDTO, Book book);

	BookDTO mapBookEntityToDTO(BookDTO bookDTO, Book book);

	LibraryDTO mapLibraryEntityToDTO(LibraryDTO libraryDTO, Library library);

}
