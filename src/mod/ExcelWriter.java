package mod;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import app.Column;

import javax.swing.JOptionPane;

public final class ExcelWriter {

	public static final String NEWLINE = System.lineSeparator();
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final String TEMPLATE_SHEET = "Template";
	private static final String COMPANY_NAME = "ImpactInt";
	private static final String PRODUCT_TYPE = "home";
	private static final int HEADER_ROW = 2;
	private static ExcelWriter INSTANCE;
	private int startingRowNum = -1;
	private int colIndex = 0;
	private Workbook workbook;
	private File file;


	private ExcelWriter() {};

	public static ExcelWriter getInstance() {
		if (INSTANCE == null) 
			INSTANCE = new ExcelWriter();
		return INSTANCE;
	}

	public boolean setDoc(File file) throws EncryptedDocumentException, InvalidFormatException, IOException {
		workbook = WorkbookFactory.create(file);
		if (workbook.getSheet(TEMPLATE_SHEET) == null) {
			workbook = null;
			return false;
		} else {
			this.file = file;
			return true;
		}
	}

	public boolean write(int numOfEntries) throws IOException {
		Sheet template = openWorkbook();
		if (template == null) {
			return false;
		} else {
			Row header = template.getRow(HEADER_ROW);
			if (startingRowNum == -1) {
				startingRowNum = getEmptyRowNum(template);
			}
			Iterator<Cell> currentHead = header.cellIterator();
			while (currentHead.hasNext()) {
				Cell currentTopCell = currentHead.next();
				Column value = null;
				try {
					value = Column.valueOf(currentTopCell.getStringCellValue().toUpperCase());
				} catch (IllegalArgumentException e) {
					continue;
				}
				switch (value) {
				case MANUFACTURER:
				case BRAND_NAME:
					writeString(COMPANY_NAME, template, numOfEntries);
					break;
				case FEED_PRODUCT_TYPE:
					writeString(PRODUCT_TYPE, template, numOfEntries);
					break;
				case ITEM_TYPE:
					break;
				default:
				}
				colIndex++;
			}
			colIndex = 0;
		}
		FileOutputStream fileOut = new FileOutputStream(this.file.getPath().substring(0,
                this.file.getAbsolutePath().lastIndexOf(File.separator)) + File.separator + "out.xlsx");
		workbook.write(fileOut);
		workbook.close();
		return true;
	}

	private int getEmptyRowNum(Sheet template) {
		Iterator<Row> rowIterator = template.rowIterator();
		int index = -1;
		while (rowIterator.hasNext()) {
			rowIterator.next();
			index++;
		}
		return index + 1;
	}

	private void writeString(String value, Sheet sheet, int count) {
		int rowIndex = startingRowNum;
		do {
			Row row = (sheet.getRow(rowIndex) == null)? sheet.createRow(rowIndex++) : sheet.getRow(rowIndex++);
			Cell cell = row.createCell(colIndex);
			cell.setCellType(CellType.STRING);	
			cell.setCellValue(value);
			count--;
		} while (count != 0);
	}

	private Sheet openWorkbook() {
		if (workbook == null) { 
			return null;
		} 
		return workbook.getSheet(TEMPLATE_SHEET);
	}
}
