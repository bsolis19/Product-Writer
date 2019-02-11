package gui;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import app.Style;
import app.Color;
import app.Unit;

import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.Box;

public class DetailsPanel extends JPanel {
	
	private static final long serialVersionUID = 6284713782247794714L;
	private JTextField frameDepthTF;
	private JTextField backWidthTF;
	private JTextField frameIdTF;
	private JTextField frameWidthTF;
	private JTextField rabbetDepthTF;
	private JTextField linerWidthTF;

	public DetailsPanel() {
		super(new CardLayout());
		JPanel boxedPane = new JPanel();
		JPanel formPanel = new JPanel(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(55dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(94dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(54dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("67dlu:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,}));
		formPanel.setMaximumSize(new Dimension(32767, 700));
		
		JLabel lblFrameId = new JLabel("Frame ID:");
		JLabel lblFrameColor = new JLabel("Frame Color:");
		JLabel lblFrameWidth = new JLabel("Frame Width:");
		JLabel lblBackWidth = new JLabel("Back Width:");
		JLabel lblFrameDepth = new JLabel("Frame Depth:");
		JLabel lblLinerWidth = new JLabel("Liner Width:");
		JLabel lblLinerColor = new JLabel("Liner Color:");
		JLabel lblRabbetDepth = new JLabel("Rabbet Depth:");
		JLabel lblStyle = new JLabel("Style:");
		JLabel lblDescription = new JLabel("Description:");
		
		JPanel frameIdContainer = new JPanel();
		
		frameIdTF = new JTextField(15);
		frameIdContainer.add(frameIdTF);
		formPanel.add(lblFrameId, "2, 2, right, default");
		formPanel.add(frameIdContainer, "4, 2, left, fill");
		
		JPanel frameColorContainer = new JPanel();
		
		JComboBox<Color> colorsCB1 = new JComboBox<Color>(Color.values());
		frameColorContainer.add(colorsCB1);
		formPanel.add(lblFrameColor, "6, 2, right, default");
		formPanel.add(frameColorContainer, "8, 2, left, fill");
		
		JPanel frameWidthContainer = new JPanel();
		
		frameWidthTF = new JTextField(5);
		JComboBox<Unit> lengthCB1 = new JComboBox<Unit>(Unit.values());
		frameWidthContainer.add(frameWidthTF);
		frameWidthContainer.add(lengthCB1);
		formPanel.add(lblFrameWidth, "2, 4, right, default");
		formPanel.add(frameWidthContainer, "4, 4, left, fill");
				
		JPanel backWidthContainer = new JPanel();
		
		backWidthTF = new JTextField(5);
		JComboBox<Unit> lengthCB2 = new JComboBox<Unit>(Unit.values());
		backWidthContainer.add(backWidthTF);
		backWidthContainer.add(lengthCB2);
		formPanel.add(lblBackWidth, "6, 4, right, default");
		formPanel.add(backWidthContainer, "8, 4, left, fill");
	
		JPanel frameDepthContainer = new JPanel();

		frameDepthTF = new JTextField(5);
		JComboBox<Unit> lengthCB3 = new JComboBox<Unit>(Unit.values());
		frameDepthContainer.add(frameDepthTF);
		frameDepthContainer.add(lengthCB3);
		formPanel.add(lblFrameDepth, "2, 6, right, default");
		formPanel.add(frameDepthContainer, "4, 6, left, fill");
		
		JPanel rabbetDepthContainer = new JPanel();
		
		rabbetDepthTF = new JTextField(5);
		JComboBox<Unit> lengthCB4 = new JComboBox<Unit>(Unit.values());
		rabbetDepthContainer.add(rabbetDepthTF);
		rabbetDepthContainer.add(lengthCB4);
		formPanel.add(lblRabbetDepth, "6, 6, right, default");
		formPanel.add(rabbetDepthContainer, "8, 6, left, fill");

		JPanel linerWidthContainer = new JPanel();
		
		linerWidthTF = new JTextField(5);
		JComboBox<Unit> lengthCB5 = new JComboBox<Unit>(Unit.values());
		linerWidthContainer.add(linerWidthTF);
		linerWidthContainer.add(lengthCB5);
		formPanel.add(lblLinerWidth, "2, 8, right, default");
		formPanel.add(linerWidthContainer, "4, 8, left, fill");
		
		JPanel linerColorContainer = new JPanel();
		
		JTextField colorTF = new JTextField(10);
		linerColorContainer.add(colorTF);
		formPanel.add(lblLinerColor, "6, 8, right, default");
		formPanel.add(linerColorContainer, "8, 8, left, fill");
	
		JPanel styleContainer = new JPanel();	

		JComboBox<Style> styleCB = new JComboBox<Style>(Style.values());
		styleContainer.add(styleCB); 
		formPanel.add(lblStyle, "2, 10, right, default");
		formPanel.add(styleContainer, "4, 10, left, fill");
		
		JPanel descriptionContainer = new JPanel();
		JPanel nestedPanel = new JPanel();
		
		descriptionContainer.setLayout(new BorderLayout(0, 0));
		descriptionContainer.add(nestedPanel, BorderLayout.CENTER);
		
		nestedPanel.setLayout(new BoxLayout(nestedPanel, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		nestedPanel.add(horizontalStrut);
		
		nestedPanel.add(lblDescription);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(350, 70));
		
		JTextArea descriptionTA = new JTextArea();
		descriptionTA.setLineWrap(true);
		scrollPane.setViewportView(descriptionTA);
		nestedPanel.add(scrollPane);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		nestedPanel.add(horizontalStrut_1);
		boxedPane.setLayout(new BoxLayout(boxedPane, BoxLayout.Y_AXIS));
		boxedPane.add(formPanel);
		boxedPane.add(descriptionContainer);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		boxedPane.add(verticalStrut);

		add(boxedPane);
	}
}
