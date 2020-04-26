package com.genpact;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.genpact.dao.BookDao;
import com.genpact.dao.LibraryDao;
import com.genpact.model.Book;
import com.genpact.model.Library;

/**
 * This is the main application runner class for Spring boot application.
 * @author Reetesh R Nayak
 *
 */
@SpringBootApplication
public class LibraryApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplicationRunner.class, args);
	}

	/**
	 * This method is used to create some data in h2 database tables as soon as the server starts
	 * so that can be used to display some default items in the UI screen.
	 * @param libDao
	 * @param bookDao
	 * @return
	 */
	@Bean
	public CommandLineRunner init(LibraryDao libDao, BookDao bookDao) {
		return args -> {
			Library library1 = new Library();
			library1.setName("The British Library");
			library1.setType("Public libraries");
			libDao.save(library1);
			
			Library library2 = new Library();
			library2.setName("Wren Library");
			library2.setType("Special libraries");
			libDao.save(library2);
			
			Library library3 = new Library();
			library3.setName("Kedermister Library");
			library3.setType("School libraries");
			libDao.save(library3);
			
			Book book1 = new Book();
			book1.setName("Life Of Pie");
			book1.setAuthor("Yann Martel");
			book1.setYear(2001);
			book1.setLid(1);
			bookDao.save(book1);

			Book book2 = new Book();
			book2.setName("Lord of the Rings");
			book2.setAuthor("J. R. R. Tolkien");
			book2.setYear(1954);
			book1.setLid(1);
			bookDao.save(book2);
			
			Book book3 = new Book();
			book3.setName("The Three Musketeers");
			book3.setAuthor("Alexander Dumas");
			book3.setYear(1954);
			book3.setLid(1);
			bookDao.save(book3);
			
			Book book4 = new Book();
			book4.setName("Development as Freedom");
			book4.setAuthor("Amartya Sen");
			book4.setYear(1985);
			book4.setLid(2);
			bookDao.save(book4);
		};
	}

}
