package gui;

import java.awt.*;        // Using AWT layouts
import javax.swing.*;     // Using Swing components and containers

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;

// A Swing GUI application inherits from top-level container javax.swing.JFrame
public class AppFrame extends JFrame {

	private static final long serialVersionUID = 736062957160107799L;
	public static final int FRAME_WIDTH = 570;
	public static final int FRAME_HEIGHT = 504;
	public static final String TITLE = "Product Form";

	public AppFrame() {
		try{
			UIManager.setLookAndFeel(new Plastic3DLookAndFeel());//using jgoodies look
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
