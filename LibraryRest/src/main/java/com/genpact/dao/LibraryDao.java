package com.genpact.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.genpact.model.Library;

/**
 * 
 * @author Reetesh R Nayak
 *
 */
@Repository
public interface LibraryDao extends CrudRepository<Library, Integer> {

}
