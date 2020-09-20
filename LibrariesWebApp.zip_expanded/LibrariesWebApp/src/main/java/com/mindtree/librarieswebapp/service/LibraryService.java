package com.mindtree.librarieswebapp.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.mindtree.librarieswebapp.entity.Library;

public interface LibraryService {

	public boolean saveLibrary(Library library);

	public List<Library> listAllLibrary();

	public Library getLibrary(long id);

	public void updateLibrary(Library library, long id);

	public void deleteLibrary(long id);

	public ByteArrayInputStream writingLibraryDataIntoExcel();

	//public List<LibraryDTO> readLibraryDataFromExcel();

}
