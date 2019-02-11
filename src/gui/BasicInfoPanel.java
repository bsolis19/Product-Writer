package gui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import app.Material;
import app.ProductType;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Dimension;

public class BasicInfoPanel extends JPanel {
	
	private static final long serialVersionUID = -5698139544662537095L;

	private static final String TITLE_HINT = "Enter a title for the parent listing (e.g. 4\" Ornate Baroque French Rose Gold Wooden Picture Frame)";
	
	private JTextField titleTF;
	private JTextField sizeTF;
	private JTextField colorTF;
	private JTextField priceTF;
	private JTextField shippingTF;
	private JTextField qtyTF;

	public BasicInfoPanel() {
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel lblTitle = new JLabel("Title:");
		add(lblTitle);
		
		titleTF = new JTextField();
		titleTF.setToolTipText(TITLE_HINT);
		springLayout.putConstraint(SpringLayout.NORTH, lblTitle, 3, SpringLayout.NORTH, titleTF);
		springLayout.putConstraint(SpringLayout.EAST, lblTitle, -5, SpringLayout.WEST, titleTF);
		springLayout.putConstraint(SpringLayout.NORTH, titleTF, 33, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, titleTF, 75, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, titleTF, -25, SpringLayout.EAST, this);
		titleTF.setHorizontalAlignment(SwingConstants.LEFT);
		add(titleTF);
		titleTF.setColumns(10);
		
		JLabel lblProductType = new JLabel("Product Type:");
		springLayout.putConstraint(SpringLayout.NORTH, lblProductType, 79, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblProductType, 0, SpringLayout.WEST, lblTitle);
		add(lblProductType);
		
		JComboBox<ProductType> comboBox = new JComboBox<ProductType>(ProductType.values());
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, -3, SpringLayout.NORTH, lblProductType);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, lblProductType);
		add(comboBox);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 27, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblTitle);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, titleTF);
		
		panel.setBorder(BorderFactory.createTitledBorder("Variations:"));
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(panel_1, BorderLayout.NORTH);
		
		JCheckBox chckbxSize = new JCheckBox("Size");

		JCheckBox chckbxColor = new JCheckBox("Color");
		springLayout.putConstraint(SpringLayout.WEST, chckbxColor, 166, SpringLayout.WEST, this);
		
		JCheckBox chckbxMaterial = new JCheckBox("Material");
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.add(chckbxSize);
		panel_1.add(chckbxColor);
		panel_1.add(chckbxMaterial);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("68px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("128px:grow"),
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("24px"),
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblAddSize = new JLabel("Size:");
		panel_2.add(lblAddSize, "1, 2, right, center");
		
		sizeTF = new JTextField();
		panel_2.add(sizeTF, "3, 2, fill, default");
		sizeTF.setColumns(10);
		
		JLabel lblAddColor = new JLabel("Color:");
		panel_2.add(lblAddColor, "1, 4, right, center");
		
		colorTF = new JTextField();
		panel_2.add(colorTF, "3, 4, fill, default");
		colorTF.setColumns(10);
		
		JLabel lblAddMaterial = new JLabel("Material:");
		panel_2.add(lblAddMaterial, "1, 6, right, center");
		
		JComboBox<Material> materialsCB = new JComboBox<Material>(Material.values());
		panel_2.add(materialsCB, "3, 6, fill, default");
		
		JLabel lblPrice = new JLabel("Price:");
		panel_2.add(lblPrice, "1, 8, right, center");
		
		priceTF = new JTextField();
		panel_2.add(priceTF, "3, 8, left, default");
		priceTF.setMaximumSize(new Dimension(48, 21));
		priceTF.setMinimumSize(new Dimension(20, 16));
		priceTF.setColumns(5);
		
		JLabel lblShipping = new JLabel("Shipping:");
		panel_2.add(lblShipping, "1, 10, right, center");
		
		shippingTF = new JTextField();
		panel_2.add(shippingTF, "3, 10, left, default");
		shippingTF.setColumns(5);
		
		JLabel lblQty = new JLabel("Qty:");
		panel_2.add(lblQty, "1, 12, right, default");
		
		qtyTF = new JTextField();
		panel_2.add(qtyTF, "3, 12, left, default");
		qtyTF.setColumns(3);
		
		JButton btnAdd = new JButton("Add");
		panel_2.add(btnAdd, "3, 14");
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.setBorder(BorderFactory.createTitledBorder("List"));
		
		JList list = new JList();
		panel_3.add(list, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.SOUTH);
		
		JButton btnDelete = new JButton("Delete");
		panel_4.add(btnDelete);
		
		JButton btnClear = new JButton("Clear");
		panel_4.add(btnClear);

	}
}
