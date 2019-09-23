package app;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import mod.ExcelWriter;

public class WriteOutputCommand implements Command {
	
	private ExcelWriter writer;
	
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static final String NEWLINE = System.lineSeparator();
	
	public WriteOutputCommand() {
		this.writer = ExcelWriter.getInstance();
	}

	@Override
	public void execute() {
		try {
			writer.write(5);
			LOGGER.log(Level.INFO, "Wrote To File Successfully" + NEWLINE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setDoc(File file) {
		try {
			writer.setDoc(file);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
