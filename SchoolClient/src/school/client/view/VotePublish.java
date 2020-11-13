package school.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VotePublish extends JFrame implements PublishConstants{
	public VotePublish() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(PAGE_WIDTH, PAGE_HEIGHT));
		setTitle("发布投票");
		
		themeLabel = new JLabel(" 投票主题");
		themeLabel.setForeground(Color.lightGray);
		themeLabel.setFont(new Font("", Font.PLAIN, 15));
		themeLabel.setBounds(30, 10, 90, 25);
		themeArea = new JTextArea();
		themeArea.setFont(new Font("", Font.PLAIN, 16));
		themeArea.setBounds(30, 10, 460, 25);
		
		optionTypes = new String[3];
		optionTypes[0] = "投票类型";
		optionTypes[1] = "单选";
		optionTypes[2] = "多选，无限制";
		typeCombo = new JComboBox(optionTypes);
		typeCombo.setBounds(265, 40, 225, 25);
	
		documentLabel = new JLabel(" 文稿");
		documentLabel.setForeground(Color.lightGray);
		documentLabel.setFont(new Font("", Font.PLAIN, 15));
		documentLabel.setBounds(30, 70, 90, 25);
		documentArea = new JTextArea();
		documentArea.setFont(new Font("", Font.PLAIN, 16));
		documentPane = new JScrollPane(documentArea);
		documentPane.setBounds(30, 70, 460, 65);
		
		OptionPane optionPane = new OptionPane();
		OptionPaneControl numCombo = new OptionPaneControl(optionPane);
		
		cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("", Font.PLAIN, 14));
		cancelButton.setBounds(137, 405, 120, 34);
		cancelButton.addActionListener(new ButtonListener());
		publishButton = new JButton("发布");
		publishButton.setFont(new Font("", Font.PLAIN, 14));
		publishButton.setBounds(263, 405, 120, 34);
		publishButton.addActionListener(new ButtonListener());
		
		votePanel = new JPanel();
		votePanel.setLayout(null);
		votePanel.add(themeLabel);
		votePanel.add(themeArea);
		votePanel.add(numCombo);
		votePanel.add(typeCombo);
		votePanel.add(documentLabel);
		votePanel.add(documentPane);
		votePanel.add(optionPane);
		votePanel.add(cancelButton);
		votePanel.add(publishButton);
		
		getContentPane().add(votePanel);
		pack();
		setVisible(true);
		}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cancelButton) {
				VotePublish.this.dispose();
			} else {
				
			}
		}
	}
	
	private String[] optionTypes;
	private JLabel themeLabel, documentLabel;
	private JTextArea themeArea, documentArea;
	private JComboBox typeCombo;
	private JButton cancelButton, publishButton;
	private JPanel votePanel;
	private JScrollPane documentPane; 

}
