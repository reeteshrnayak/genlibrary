package com.genpact.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.dao.LibraryDao;
import com.genpact.model.Library;
import com.genpact.model.LibraryDTO;
import com.genpact.service.ILibraryService;

/**
 * 
 * @author Reetesh R Nayak
 *
 */
@Transactional
@Service
public class LibrayServiceImpl implements ILibraryService {

	private static final Logger LOGGER = LogManager.getLogger(LibrayServiceImpl.class.getName());

	@Autowired
	private LibraryDao libDao;

	public List<Library> getAllLibs() {
		List<Library> list = new ArrayList<>();
		try {
			libDao.findAll().iterator().forEachRemaining(list::add);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while fetching Library Details:" + e);
		}
		return list;
	}

	@Override
	public Library save(LibraryDTO libDTO) {
		Library lib = new Library();
		lib.setName(libDTO.getName());
		lib.setType(libDTO.getType());
		try {
			return libDao.save(lib);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while creating Library Details:" + e);
		}
		return new Library();
	}
}
