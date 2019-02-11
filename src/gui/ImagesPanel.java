package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ImagesPanel extends JPanel {

	private static final long serialVersionUID = -1754797750301982930L;

	public ImagesPanel() {
		super(new BorderLayout());
		setPreferredSize(new Dimension());
		JPanel topPanel  = new JPanel();
		JPanel sidePanel = new JPanel();
		JPanel centerPanel = new JPanel();
		
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		ButtonGroup isTrueGroup = new ButtonGroup();
		topPanel.add(new Label("Will images vary by child?"));
		JRadioButton trueRB = new JRadioButton("Yes", true);
		isTrueGroup.add(trueRB);
		topPanel.add(trueRB);
		JRadioButton falseRB = new JRadioButton("No");
		isTrueGroup.add(falseRB);
		topPanel.add(falseRB);
		
		add(centerPanel, BorderLayout.CENTER);
		add(sidePanel, BorderLayout.WEST);
		add(topPanel, BorderLayout.NORTH);
	}
}
