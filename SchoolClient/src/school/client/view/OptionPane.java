package school.client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class OptionPane extends JScrollPane {
	public OptionPane() {	
		setBounds(30, 145, 460, 246);
		setBackground(Color.white);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		optionPanel = new JPanel();
		optionPanel.setBackground(Color.white);
		optionPanel.setLayout(null);
		options = new JTextField[optionNum];
		optionLabels = new JLabel[optionNum];
		for(int i = 0; i < optionNum; i++) {
			optionLabels[i] = new JLabel("选项" + (i + 1));
			optionLabels[i].setBounds(0, 24 * i, 42, 25);
			optionLabels[i].setOpaque(true);
			optionLabels[i].setBackground(Color.white);
			optionLabels[i].setForeground(Color.gray);
			options[i] = new JTextField();
			options[i].setFont(new Font("", Font.PLAIN, 16));
			options[i].setBounds(38, 24 * i, 420, 25);
			options[i].addActionListener(new ContentListener());
			optionPanel.add(optionLabels[i]);
			optionPanel.add(options[i]);
		}
		setViewportView(optionPanel);
	}
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		optionPanel = new JPanel();
		optionPanel.setBackground(Color.white);
		optionPanel.setLayout(null);
		options = new JTextField[optionNum];
		optionLabels = new JLabel[optionNum];
		for(int i = 0; i < optionNum; i++) {
			optionLabels[i] = new JLabel("选项" + (i + 1));
			optionLabels[i].setBounds(0, 24 * i, 42, 25);
			optionLabels[i].setOpaque(true);
			optionLabels[i].setBackground(Color.white);
			optionLabels[i].setForeground(Color.gray);
			options[i] = new JTextField();
			options[i].setFont(new Font("", Font.PLAIN, 16));
			options[i].setBounds(38, 24 * i, 420, 25);
			options[i].addActionListener(new ContentListener());
			optionPanel.add(optionLabels[i]);
			optionPanel.add(options[i]);
		}
		setViewportView(optionPanel);
	}

	public void setNum(int number) {
		optionNum = number;
	}
	
	private class ContentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private int optionNum = 2;
	private JPanel optionPanel;
	JTextField[] options;
	JLabel[] optionLabels;
}
