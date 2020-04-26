package com.genpact.utility;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.genpact.model.Book;
import com.genpact.model.BookDTO;
import com.genpact.model.Library;
import com.genpact.model.LibraryDTO;

/**
 * This is a converter class to convert business entity into data transfer
 * object DTO.
 * 
 * @author Reetesh R Nayak
 *
 */
@Service
public class Converter {

	/**
	 * 
	 * @param books
	 * @return
	 */
	public List<BookDTO> convertToDTOList(List<Book> books) {

		List<BookDTO> dtoList = new ArrayList<>();
		if (null != books && !books.isEmpty()) {
			for (Book book : books) {
				BookDTO dto = this.convertToDTO(book);
				dtoList.add(dto);
			}
		}
		return dtoList;

	}

	/**
	 * 
	 * @param book
	 * @return
	 */
	public BookDTO convertToDTO(Book book) {
		BookDTO dto = new BookDTO();
		dto.setId(book.getId());
		dto.setName(book.getName());
		dto.setAuthor(book.getAuthor());
		dto.setYear(book.getYear());
		dto.setLid(book.getLid());
		return dto;
	}
	
	/**
	 * 
	 * @param bookDTO
	 * @return
	 */
	public Book convertToEntity(BookDTO bookDTO) {
		Book book = new Book();
		book.setId(bookDTO.getId());
		book.setName(bookDTO.getName());
		book.setAuthor(bookDTO.getAuthor());
		book.setYear(bookDTO.getYear());
		book.setLid(bookDTO.getLid());
		return book;
	}

	/**
	 * 
	 * @param libList
	 * @return
	 */
	public List<LibraryDTO> convertToLibraryDTOList(List<Library> libList) {
		List<LibraryDTO> dtoList = new ArrayList<>();
		if (null != libList && !libList.isEmpty()) {
			for (Library library : libList) {
				LibraryDTO dto = this.convertToLibraryDTO(library);
				dtoList.add(dto);
			}
		}
		return dtoList;
	}

	/**
	 * 
	 * @param lib
	 * @return
	 */
	public LibraryDTO convertToLibraryDTO(Library lib) {
		LibraryDTO dto = new LibraryDTO();
		dto.setId(lib.getId());
		dto.setName(lib.getName());
		dto.setType(lib.getType());
		return dto;
	}

}
