package app;

import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import gui.AppFrame;
import mod.ExcelWriter;
import model.Product;

public class Dispatcher{
	private static ExcelWriter excelWriter;
	
	static {
		excelWriter = ExcelWriter.getInstance();
	}
	
	public boolean writeContents() {
		try {
			return excelWriter.write(5);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public void setDoc(File file) {
		try {
			excelWriter.setDoc(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Product objectifyData(AppFrame appFrame) {
		JPanel[] panels = (JPanel[]) ((JTabbedPane)appFrame.getContentPane().getComponent(0)).getComponents();
		for (int i = 0; i < panels.length; i++) {
			
		}
		return null;
	}

}
