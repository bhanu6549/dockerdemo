package com.mindtree.librarieswebapp.service.serviceimplementation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.librarieswebapp.entity.Library;
import com.mindtree.librarieswebapp.repository.LibraryRepository;
import com.mindtree.librarieswebapp.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;

	public boolean saveLibrary(Library library) {
		if (libraryRepository.findByLibraryName(library.getLibraryName()).isPresent()) {
			return false;
		}
		libraryRepository.save(library);
		return true;
	}

	public List<Library> listAllLibrary() {
		/* writingLibraryDataIntoExcel(); */
		return libraryRepository.findAll();

	}

	public Library getLibrary(long id) {
		return libraryRepository.findById(id).get();
	}

	public void updateLibrary(Library library, long id) {
		Library library2 = libraryRepository.findById(id).get();
		library2.setLibraryName(library.getLibraryName());

		libraryRepository.save(library2);
	}

	public void deleteLibrary(long id) {
		libraryRepository.deleteById(id);
	}

	public ByteArrayInputStream writingLibraryDataIntoExcel() {
		List<Library> libraries = libraryRepository.findAll();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Libraries");

			Row row;
			row = sheet.createRow(0);
			Cell cell01 = row.createCell(0);
			cell01.setCellValue("Library_Id");
			Cell cell02 = row.createCell(1);
			cell02.setCellValue("Library_Name");
			Cell cell03 = row.createCell(2);
			cell03.setCellValue("No_Of_Books");

			int rownum = 1;

			for (Library library : libraries) {

				row = sheet.createRow(rownum++);
				Cell cell1 = row.createCell(0);
				cell1.setCellValue((long) library.getLibraryId());

				Cell cell2 = row.createCell(1);
				cell2.setCellValue(library.getLibraryName());

				Cell cell3 = row.createCell(2);
				cell3.setCellValue((long) library.getNoOfBooks());

			}

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			workbook.write(outputStream);
			workbook.close();
			return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * public List<LibraryDTO> readLibraryDataFromExcel() {
	 * 
	 * List<LibraryDTO> listoflibraries = new LinkedList<LibraryDTO>();
	 * FileInputStream fileInputStream; try { fileInputStream = new FileInputStream(
	 * "C:\\Users\\m1057636\\git\\repository4\\LibrariesWebApp\\src\\main\\resources\\static\\ExcelSheets\\LibraryData.xlsx"
	 * );
	 * 
	 * XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream); XSSFSheet sheet =
	 * workbook.getSheet("Libraries");
	 * 
	 * // Iterator<Row> rowIterator = sheet.iterator();
	 * 
	 * for (int i = 1; i <= sheet.getLastRowNum(); i++) { LibraryDTO libraryDTO =
	 * new LibraryDTO();
	 * 
	 * libraryDTO.setLibraryId((long)
	 * sheet.getRow(i).getCell(0).getNumericCellValue());
	 * 
	 * libraryDTO.setLibraryName(sheet.getRow(i).getCell(1).getStringCellValue());
	 * 
	 * libraryDTO.setNoOfBooks((long)
	 * sheet.getRow(i).getCell(2).getNumericCellValue());
	 * 
	 * listoflibraries.add(libraryDTO); }
	 * 
	 * workbook.close(); fileInputStream.close();
	 * 
	 * } catch (IOException e) { e.printStackTrace(); } return listoflibraries;
	 * 
	 * }
	 */
}
