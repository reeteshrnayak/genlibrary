package com.genpact.controller;

import java.io.IOException;
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

import com.genpact.config.LibraryException;
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
	public ResultWrapper<BookDTO> saveUser(@RequestBody BookDTO book) throws IOException {

		BookDTO dto = new BookDTO();
		try {
			dto = converter.convertToDTO(bookService.save(converter.convertToEntity(book)));
		} catch (Exception e) {
			LOGGER.error(e);
			throw new LibraryException("L002", "Error while saving book list. Please contact Admin.");
		}

		return new ResultWrapper<>(HttpStatus.OK.value(), "Book added successfully.", dto);
	}

	@GetMapping("/lib/{lid}")
	public ResultWrapper<List<BookDTO>> listBook(@PathVariable int lid) throws IOException {

		List<BookDTO> bookList = new ArrayList<>();
		try {
			bookList = converter.convertToDTOList(bookService.findAllBooksByLibId(lid));
		} catch (Exception e) {
			LOGGER.error(e);
			throw new LibraryException("L001", "Error while fetching book list. Please contact Admin.");
		}
		return new ResultWrapper<>(HttpStatus.OK.value(), "Book list fetched successfully.", bookList);
	}

	@GetMapping("/{id}")
	public ResultWrapper<BookDTO> getOne(@PathVariable int id) throws IOException {

		BookDTO dto = new BookDTO();
		try {
			dto = converter.convertToDTO(bookService.findById(id));
		} catch (Exception e) {
			LOGGER.error(e);
			throw new LibraryException("L003", "Error while fetching book details. Please contact Admin.");
		}

		return new ResultWrapper<>(HttpStatus.OK.value(), "Book fetched successfully.", dto);
	}

	@PutMapping("/{id}")
	public ResultWrapper<BookDTO> update(@RequestBody BookDTO book) throws IOException {
		BookDTO dto = new BookDTO();
		try {
			dto = converter.convertToDTO(bookService.update(converter.convertToEntity(book)));
		} catch (Exception e) {
			LOGGER.error(e);
			throw new LibraryException("L004", "Error while updating book list. Please contact Admin.");
		}
		return new ResultWrapper<>(HttpStatus.OK.value(), "Book updated successfully.", dto);
	}

	@DeleteMapping("/{id}")
	public ResultWrapper<Void> delete(@PathVariable int id) throws IOException {
		try {
			bookService.delete(id);
		} catch (Exception e) {
			LOGGER.error(e);
			throw new LibraryException("L004", "Error while deleting book. Please contact Admin.");
		}
		return new ResultWrapper<>(HttpStatus.OK.value(), "Book deleted successfully.", null);
	}

}
