package app;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import mod.ExcelWriter;

public class Dispatcher{
	private static ExcelWriter eWriter;
	
	static {
		eWriter = ExcelWriter.getInstance();
	}
	
	public boolean writeContents() {
		try {
			return eWriter.write(5);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void setDoc(File file) {
		try {
			eWriter.setDoc(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
