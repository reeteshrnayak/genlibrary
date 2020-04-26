package com.genpact.service;

import java.util.List;

import com.genpact.model.Library;
import com.genpact.model.LibraryDTO;


/**
 * 
 * @author Reetesh R Nayak
 *
 */
public interface ILibraryService {

	Library save(LibraryDTO user);

	List<Library> getAllLibs();

}
