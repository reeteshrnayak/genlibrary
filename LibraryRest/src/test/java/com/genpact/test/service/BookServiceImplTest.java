package com.genpact.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.genpact.dao.BookDao;
import com.genpact.model.Book;
import com.genpact.service.impl.BookServiceImpl;
import com.genpact.test.data.TestData;

/**
 * 
 * @author Reetesh R Nayak
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {

	@InjectMocks
	BookServiceImpl bookService;

	@Mock
	BookDao bookDao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void findAllByLibIdTest() {
		List<Book> list = TestData.createBook();
		when(bookDao.findAllByLibId(1)).thenReturn(list);

		List<Book> bookList = bookService.findAllBooksByLibId(1);
		assertEquals(3, bookList.size());
	}

}
