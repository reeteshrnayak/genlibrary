package com.genpact.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.dao.BookDao;
import com.genpact.model.Book;
import com.genpact.model.BookDTO;
import com.genpact.service.IBookService;

/**
 * 
 * @author Reetesh R Nayak
 *
 */
@Transactional
@Service
public class BookServiceImpl implements IBookService {

	private static final Logger LOGGER = LogManager.getLogger(BookServiceImpl.class.getName());

	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> findAllBooksByLibId(int lid) {
		try {
			return bookDao.findAllByLibId(lid);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while fetching Book Details:" + e);
		}
		return Collections.emptyList();
	}

	@Override
	public void delete(int id) {
		try {
			bookDao.deleteById(id);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while deleting Book:" + e);
		}
	}

	@Override
	public Book findById(int id) {
		try {
			Optional<Book> bookOp = bookDao.findById(id);
			return bookOp.isPresent() ? bookOp.get() : new Book();
		} catch (Exception e) {
			LOGGER.error("Exception occurred while deleting Book:" + e);
		}
		return new Book();
	}

	@Override
	public BookDTO update(BookDTO bookDTO) {
		try {
			Book book = findById(bookDTO.getId());
			if (book != null) {
				BeanUtils.copyProperties(bookDTO, book, "id");
				bookDao.save(book);
			}
		} catch (Exception e) {
			LOGGER.error("Exception occurred while updating Book details :" + e);
		}
		return bookDTO;
	}

	@Override
	public Book save(BookDTO bookDTO) {
		Book book = new Book();
		book.setName(bookDTO.getName());
		book.setAuthor(bookDTO.getAuthor());
		book.setYear(bookDTO.getYear());
		book.setLid(bookDTO.getLid());
		try {
			return bookDao.save(book);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while saving Book details :" + e);
		}
		return new Book();
	}
}
