package com.genpact.test.data;

import java.util.ArrayList;
import java.util.List;

import com.genpact.model.Book;

/**
 * 
 * @author Reetesh R Nayak
 *
 */
public class TestData {

	public static String getBookJson(long id) {
		return "{\"id\":\"" + id
				+ "\", \"name\":\"Genpact Interview\", \"author\":\"Reetesh\", \"year\":\"2020\", \"lid\":\"1\"}";
	}

	public static List<Book> createBook() {
		List<Book> list = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setId(1);
		book1.setName("Life Of Pie");
		book1.setAuthor("Yann Martel");
		book1.setYear(2001);
		book1.setLid(1);

		Book book2 = new Book();
		book2.setId(2);
		book2.setName("Lord of the Rings");
		book2.setAuthor("J. R. R. Tolkien");
		book2.setYear(1954);
		book1.setLid(1);

		Book book3 = new Book();
		book3.setId(3);
		book3.setName("The Three Musketeers");
		book3.setAuthor("Alexander Dumas");
		book3.setYear(1954);
		book3.setLid(1);

		list.add(book1);
		list.add(book2);
		list.add(book3);

		return list;
	}
}
