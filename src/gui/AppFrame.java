package gui;

import java.awt.*;        // Using AWT layouts
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;     // Using Swing components and containers

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import mod.ExcelWriter;

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class AppFrame extends JFrame {

	private static final long serialVersionUID = 736062957160107799L;
	public static final int FRAME_WIDTH = 570;
	public static final int FRAME_HEIGHT = 504;
	public static final String TITLE = "Product Form";

	public AppFrame() {
		setTitle(TITLE);
		setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(createTabbedPane());
		pack();
		setLocationRelativeTo(null);
		setVisible(true);  
	}

	private Component createTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Basic Info", new BasicInfoPanel());
		tabbedPane.addTab("Details", new DetailsPanel());
		tabbedPane.addTab("Images", new ImagesPanel());
		return tabbedPane;
	}
}
