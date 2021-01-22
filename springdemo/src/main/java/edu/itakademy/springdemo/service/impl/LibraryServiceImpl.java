package edu.itakademy.springdemo.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.itakademy.springdemo.model.Book;
import edu.itakademy.springdemo.model.Library;
import edu.itakademy.springdemo.model.dto.LibraryDTO;
import edu.itakademy.springdemo.repository.BookRepository;
import edu.itakademy.springdemo.repository.LibraryRepository;
import edu.itakademy.springdemo.service.BookService;
import edu.itakademy.springdemo.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private LibraryRepository libraryRepository;

	@Override
	public Library getLibrary(Integer id) {
		return this.libraryRepository.getLibraryById(id) ;
	}

	@Override
	public List<Library> getAllLibraries() {
		return this.libraryRepository.getAllLibraries() ;
	}

	@Override
	public void saveLibrary(Library library) {
		this.libraryRepository.save(library);
	}

	@Override
	public Library updateLibrary(Integer id, LibraryDTO libraryDTO) {
		Library library = mapToEntity(libraryDTO, this.getLibrary(id));
		this.libraryRepository.update(library);
		return library;
	}

	@Override
	public void delete(Integer id) {
		this.libraryRepository.delete(this.getLibrary(id));
	}
	
    private LibraryDTO mapToDTO(Library library, LibraryDTO libraryDTO) {
    	libraryDTO.setName(library.getName());
        return libraryDTO;
    }

    private Library mapToEntity(LibraryDTO libraryDTO, Library library) {
        library.setName(libraryDTO.getName());
        return library;
    }
	
	

}
