package com.genpact.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.model.LibraryDTO;
import com.genpact.model.ResultWrapper;
import com.genpact.service.ILibraryService;
import com.genpact.utility.Converter;

/**
 * 
 * @author Reetesh R Nayak
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/libs")
public class LibraryController {

	private static final Logger LOGGER = LogManager.getLogger(BookController.class.getName());
	
	@Autowired
	private ILibraryService libraryService;
	
	@Autowired
	private Converter converter;
	
	@GetMapping
	public ResultWrapper<List<LibraryDTO>> listLibs() {
		List<LibraryDTO> libList = new ArrayList<>();
		String message = "";
		try {
			libList = converter.convertToLibraryDTOList(libraryService.getAllLibs());
			message = "Library list fetched successfully.";
		} catch (Exception e) {
			LOGGER.error(e);
			message = "Error while fetching library list. Please contact Admin.";
		}
		return new ResultWrapper<>(HttpStatus.OK.value(), message, libList);
	}

}
