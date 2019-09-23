package app;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

public class ChooseFileCommand implements Command{
	
	JFileChooser fileChooser;
	Controller controller;
	
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static final String NEWLINE = System.lineSeparator();

	public ChooseFileCommand(Controller controller) {
		this.controller = controller;
		this.fileChooser = new JFileChooser();
	}
	
	@Override
	public void execute() {
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			controller.setFile(file);
			LOGGER.log(Level.INFO, "Selected File: " + file.getName() + "." + NEWLINE);
		} else {
			LOGGER.log(Level.INFO, "Choose command cancelled by user." + NEWLINE);
		}
	}

}
