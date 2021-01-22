package edu.itakademy.springdemo.service;

import java.util.List;

import edu.itakademy.springdemo.model.Library;
import edu.itakademy.springdemo.model.dto.LibraryDTO;

public interface LibraryService {

   Library getLibrary(Integer id);

   List<Library> getAllLibraries();
   
   void saveLibrary(Library library);
   
   Library updateLibrary(Integer integer, LibraryDTO libraryDTO);
   
   void delete (Integer id);
	
}
