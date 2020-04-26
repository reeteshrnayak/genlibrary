package com.genpact.service;

import java.util.List;

import com.genpact.model.Book;

/**
 * 
 * @author Reetesh R Nayak
 *
 */
public interface IBookService {

	Book save(Book book);

	List<Book> findAllBooksByLibId(int lid);

	void delete(int id);

	Book findById(int id);

	Book update(Book book);
}
