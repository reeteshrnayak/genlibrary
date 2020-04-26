package com.genpact.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.genpact.model.Book;

/**
 * 
 * @author Reetesh R Nayak
 *
 */
@Repository
public interface BookDao extends CrudRepository<Book, Integer> {

	@Query(value = "SELECT * FROM BOOK WHERE LID = ?1 ", nativeQuery = true)
	List<Book> findAllByLibId(int lid);
	
}
