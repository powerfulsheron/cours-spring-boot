package edu.itakademy.springdemo.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.itakademy.springdemo.model.Library;
import edu.itakademy.springdemo.repository.LibraryRepository;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {

	@Autowired
	private final EntityManager em;
	
    public LibraryRepositoryImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

	@Override
	public Library getLibraryById(Integer id) {
		return em.find(Library.class, id);
	}

	@Override
	public List<Library> getAllLibraries() {
		Query query = em.createQuery("SELECT e FROM Library e");
		return query.getResultList();
	}
	
	@Override
	@Transactional
    public void save(Library library) {
		em.persist(library);
    }
    
//	@Override
//    public void update(Library library, String[] params) {
//		library.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
//        executeInsideTransaction(entityManager -> em.merge(library));
//    }
//	
	@Override
	@Transactional
    public void update(Library library) {
		System.out.println(library.getId());
		em.merge(library);
    }
    
    @Override
	@Transactional
    public void delete(Library library) {
    	em.remove(library);
    }
    
}
