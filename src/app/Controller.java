package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import gui.AppFrame;
import mod.ExcelWriter;

public class Controller {

	protected Dispatcher dispatcher;
	private JFileChooser fc;
	
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static final String NEWLINE = System.lineSeparator();

	
	public Controller() {
		this.dispatcher = new Dispatcher();
		this.fc = new JFileChooser();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Controller ctrl = new Controller();
				ctrl.createAndShowGUI();
			}
		});
	}

	private void createAndShowGUI() {
		JFrame frame = new AppFrame();
		frame.setJMenuBar(createMenuBar());
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		menuBar.setBackground(new Color(154, 165, 127));
		menuBar.setPreferredSize(new Dimension(AppFrame.FRAME_WIDTH, 30));

		JMenu fileMenu = new JMenu("File");
		JMenuItem chooseMI = new JMenuItem("Choose...");
		chooseMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doChooseFileThread();
			}
		});

		fileMenu.add(chooseMI);

		JMenu actionMenu = new JMenu("Action");
		JMenuItem writeMI = new JMenuItem("Write");
		writeMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doWriteThread();
			}
		});

		actionMenu.add(writeMI);

		JMenu helpMenu = new JMenu("Help");
		JMenuItem contentMI = new JMenuItem("Help Contents");

		helpMenu.add(contentMI);

		menuBar.add(fileMenu);
		menuBar.add(actionMenu);
		menuBar.add(helpMenu);
		return menuBar;
	}

	protected void doChooseFileThread() {
		new ChooseFileThread().execute();
	}

	protected void doWriteThread() {
		new WriteThread().execute();
	}
	
	protected class WriteThread extends SwingWorker<Boolean, Void> {
		@Override
		protected Boolean doInBackground() throws Exception {
			if(dispatcher.writeContents()) {
				LOGGER.log(Level.INFO, "Wrote To File: " + fc.getSelectedFile().getName() + "." + NEWLINE);
				return true;
			} else {
				LOGGER.log(Level.WARNING, "Could Not Write To File: out.xlsx" + "." + NEWLINE);
				return false;
			}
		}
	}
	
	protected class ChooseFileThread extends SwingWorker<Void, Void> {
		@Override
		protected Void doInBackground() throws Exception {
			int returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				dispatcher.setDoc(file);
				LOGGER.log(Level.INFO, "Selected File: " + file.getName() + "." + NEWLINE);
			} else {
				LOGGER.log(Level.INFO, "Choose command cancelled by user." + NEWLINE);
			}
			return null;
		}
	}
}
