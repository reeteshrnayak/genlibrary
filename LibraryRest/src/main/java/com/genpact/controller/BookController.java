package com.genpact.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.model.Book;
import com.genpact.model.BookDTO;
import com.genpact.model.ResultWrapper;
import com.genpact.service.IBookService;
import com.genpact.utility.Converter;


/**
 * 
 * @author Reetesh R Nayak
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/books")
public class BookController {

	private static final Logger LOGGER = LogManager.getLogger(BookController.class.getName());

	@Autowired
	private IBookService bookService;

	@Autowired
	private Converter converter;

	@PostMapping
	public ResultWrapper<Book> saveUser(@RequestBody BookDTO book) {
		return new ResultWrapper<>(HttpStatus.OK.value(), "Book added successfully.", bookService.save(book));
	}

	@GetMapping("/lib/{lid}")
	public ResultWrapper<List<BookDTO>> listBook(@PathVariable int lid) {
		
		List<BookDTO> bookList = new ArrayList<>();
		String message = "";
		try {
			bookList = converter.convertToDTOList(bookService.findAllBooksByLibId(lid));
			message = "Book list fetched successfully.";
		} catch (Exception e) {
			LOGGER.error(e);
			message = "Error while fetching book list. Please contact Admin.";
		}
		return new ResultWrapper<>(HttpStatus.OK.value(), message, bookList);
	}

	@GetMapping("/{id}")
	public ResultWrapper<Book> getOne(@PathVariable int id) {
		return new ResultWrapper<>(HttpStatus.OK.value(), "Book fetched successfully.", bookService.findById(id));
	}

	@PutMapping("/{id}")
	public ResultWrapper<BookDTO> update(@RequestBody BookDTO book) {
		return new ResultWrapper<>(HttpStatus.OK.value(), "Book updated successfully.", bookService.update(book));
	}

	@DeleteMapping("/{id}")
	public ResultWrapper<Void> delete(@PathVariable int id) {
		bookService.delete(id);
		return new ResultWrapper<>(HttpStatus.OK.value(), "Book deleted successfully.", null);
	}

}
