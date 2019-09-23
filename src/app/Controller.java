
package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import gui.AppFrame;
import model.Product;

public class Controller {

	private Product product;
	private Dispatcher dispatcher;
	private File file;
	private AppFrame appFrame;
	
	private Command chooseFile;
	private Command writeOutput;
	
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static final String NEWLINE = System.lineSeparator();

	
	public Controller() {
		this.dispatcher = new Dispatcher();
		this.chooseFile = new ChooseFileCommand(this);
		this.writeOutput = new WriteOutputCommand();
	}
	
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Controller ctrl = new Controller();
				ctrl.createAndShowGUI();
			}
		});
	}

	private void createAndShowGUI() {
		this.appFrame = new AppFrame();
		this.appFrame.setJMenuBar(createMenuBar());
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
				dispatcher.setCommand(chooseFile);
				dispatcher.execute();
			}
		});

		fileMenu.add(chooseMI);

		JMenu actionMenu = new JMenu("Action");
		JMenuItem writeMI = new JMenuItem("Write");
		writeMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						((WriteOutputCommand) writeOutput).setDoc(file);
						dispatcher.setCommand(writeOutput);
						dispatcher.execute();
					}
				});
				
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

	public void setFile(File file) {
		this.file = file;		
	}
}
