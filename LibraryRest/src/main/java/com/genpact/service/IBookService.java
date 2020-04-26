package com.genpact.service;

import java.util.List;
import com.genpact.model.Book;
import com.genpact.model.BookDTO;

/**
 * 
 * @author Reetesh R Nayak
 *
 */
public interface IBookService {

	Book save(BookDTO user);

	List<Book> findAllBooksByLibId(int lid);

	void delete(int id);

	Book findById(int id);

	BookDTO update(BookDTO dto);
}
