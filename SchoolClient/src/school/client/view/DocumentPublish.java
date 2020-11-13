package school.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DocumentPublish extends JFrame implements PublishConstants {
	public DocumentPublish() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(PAGE_WIDTH, PAGE_HEIGHT));
		setTitle("起草文稿");
		
		titleLabel = new JLabel("标题（必填）");
		titleLabel.setBounds(30, 20, 90, 30);
		titleLabel.setFont(new Font("", Font.PLAIN, 15));
		titleLabel.setForeground(Color.gray);
		titleField = new JTextField();
		titleField.setBounds(28, 55, 464, 30);
		titleField.setFont(new Font("", Font.PLAIN, 30));
		remarkLabel = new JLabel("备注（必填）");
		remarkLabel.setBounds(30, 90, 90, 30);
		remarkLabel.setFont(new Font("", Font.PLAIN, 15));
		remarkLabel.setForeground(Color.gray);
		remarkField = new JTextField();
		remarkField.setBounds(28, 125, 464, 30);
		remarkField.setFont(new Font("", Font.PLAIN, 30));
		bodyLabel = new JLabel("正文（必填）");
		bodyLabel.setBounds(30, 160, 90, 30);
		bodyLabel.setFont(new Font("", Font.PLAIN, 15));
		bodyLabel.setForeground(Color.gray);
		bodyArea = new JTextArea();
		bodyArea.setBounds(30, 195, 460, 175);
		bodyArea.setFont(new Font("", Font.PLAIN, 16));
		cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("", Font.PLAIN, 14));
		cancelButton.setBounds(137, 392, 120, 40);
		cancelButton.addActionListener(new ButtonListener());
		publishButton = new JButton("发布");
		publishButton.setFont(new Font("", Font.PLAIN, 14));
		publishButton.setBounds(263, 392, 120, 40);
		publishButton.addActionListener(new ButtonListener());
		
		documentPanel = new JPanel();
		documentPanel.setLayout(null);
		documentPanel.add(titleLabel);
		documentPanel.add(titleField);
		documentPanel.add(remarkLabel);
		documentPanel.add(remarkField);
		documentPanel.add(bodyLabel);
		documentPanel.add(bodyArea);
		documentPanel.add(cancelButton);
		documentPanel.add(publishButton);
		
		getContentPane().add(documentPanel);
		pack();
		setVisible(true);
		}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cancelButton) {
				DocumentPublish.this.dispose();
			} else {
				
			}
		}
	}
	
	private JTextField titleField, remarkField;
	private JTextArea bodyArea;
	private JLabel titleLabel, remarkLabel, bodyLabel;
	private JButton cancelButton, publishButton;
	private JPanel documentPanel;
}
