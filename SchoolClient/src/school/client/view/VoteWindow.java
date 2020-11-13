package school.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class VoteWindow extends JFrame implements WindowConstants{
	public VoteWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setTitle("");
		
		displayPanel = new JPanel();
		displayPanel.setBackground(Color.white);
		displayPanel.setLayout(new BorderLayout());
		
		documentPanel = new JPanel();
		documentPanel.setBackground(Color.white);
		documentPanel.setLayout(new BoxLayout(documentPanel, BoxLayout.Y_AXIS));
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.white);
		titleLabel = new JLabel("文稿标题");
		titleLabel.setFont(new Font("", Font.PLAIN, 14));
		titlePanel.add(titleLabel);
		documentContent = new JPanel();
		documentContent.setBackground(Color.white);
		documentPanel.add(titlePanel);
		documentPanel.add(documentContent);
		documentPane = new JScrollPane(documentPanel);
		documentPane.setPreferredSize(new Dimension(DOCUMENT_WIDTH, 450));
	
		
		numPanel = new JPanel();
		numPanel.setPreferredSize(new Dimension(COMMENT_WIDTH, 20));
		numPanel.setBackground(Color.white);
		numPanel.setLayout(new BoxLayout(numPanel, BoxLayout.X_AXIS));
		commentLabel = new JLabel("建议栏");
		commentLabel.setFont(new Font("", Font.PLAIN, 14));
		numLabel = new JLabel(favourNum + " / " + readNum + " / " + totalNum);
		numLabel.setFont(new Font("", Font.PLAIN, 14));
		numLabel.setForeground(DODGER_BLUE);
		numPanel.add(commentLabel);
		numPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		numPanel.add(numLabel);
		
		eastPanel = new JPanel();
		eastPanel.setBackground(Color.white);
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		commentPanel = new JPanel();
		commentPanel.setBackground(Color.white);
		commentPane = new JScrollPane(commentPanel);
		commentPane.setPreferredSize(new Dimension(COMMENT_WIDTH, 430));
		eastPanel.add(numPanel);
		eastPanel.add(commentPane);
		
		displayPanel.add(documentPane);
		displayPanel.add(eastPanel, BorderLayout.EAST);
		displayPanel.setMinimumSize(new Dimension(WINDOW_WIDTH, 450));
		
		advicePanel = new JPanel();
		advicePanel.setBackground(Color.white);
		advicePanel.setLayout(new BoxLayout(advicePanel, BoxLayout.Y_AXIS));
		advicePanel.setMinimumSize(ADVICE_MINIMUM_SIZE);
		choiceLabel = new JLabel("我的选择");
		choiceLabel.setForeground(Color.darkGray);
		myChoicePanel = new JPanel();
		myChoicePanel.setBackground(Color.white);
		myChoicePanel.setLayout(new BoxLayout(myChoicePanel, BoxLayout.X_AXIS));
		myChoicePanel.add(choiceLabel);
		myChoicePanel.add(Box.createHorizontalGlue());
		agreePanel = new JPanel();
		agreePanel.setPreferredSize(new Dimension(WINDOW_WIDTH, AGREE_PANEL_HEIGHT));
		agreePanel.setBackground(Color.white);
		agreePanel.setLayout(new GridLayout(1, 2));
		agree = new JRadioButton("同意");
		agree.setForeground(Color.darkGray);
		agree.addActionListener(new agreeListener());
		disagree = new JRadioButton("不同意");
		disagree.setForeground(Color.darkGray);
		disagree.addActionListener(new agreeListener());
		ButtonGroup group = new ButtonGroup();
		group.add(agree);
		group.add(disagree);
		agreePanel.add(agree);
		agreePanel.add(disagree);
		adviceLabel = new JLabel("我的建议");
		adviceLabel.setForeground(Color.darkGray);
		myAdvicePanel = new JPanel();
		myAdvicePanel.setBackground(Color.white);
		myAdvicePanel.setLayout(new BoxLayout(myAdvicePanel, BoxLayout.X_AXIS));
		myAdvicePanel.add(adviceLabel);
		myAdvicePanel.add(Box.createHorizontalGlue());
		
		adviceArea = new JTextArea();
		advicePane = new JScrollPane(adviceArea);
		advicePane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		advicePane.setPreferredSize(new Dimension(WINDOW_WIDTH, ADVICE_AREA_HEIGHT)); 
		
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.white);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		cancelButton = new JButton("取消");
		cancelButton.setForeground(Color.darkGray);
		confirmButton = new JButton("确定");
		confirmButton.setForeground(Color.darkGray);
		buttonPanel.add(cancelButton);
		buttonPanel.add(confirmButton);
		
		advicePanel.add(myChoicePanel);
		advicePanel.add(agreePanel);
		advicePanel.add(myAdvicePanel);
		advicePanel.add(advicePane);
		advicePanel.add(buttonPanel);
		
		
		sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, displayPanel, advicePanel);
		sp.setOneTouchExpandable(true);
		
		getContentPane().add(sp);
		pack();
		setVisible(true);
		
	}
	
	private class agreeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private int favourNum, readNum, totalNum;
	private JButton cancelButton, confirmButton;
	private JScrollPane documentPane, commentPane, advicePane;
	private JRadioButton agree, disagree;
	private JLabel choiceLabel, adviceLabel, titleLabel, commentLabel, numLabel;
	private JPanel displayPanel, advicePanel, agreePanel, documentPanel, documentContent,
	commentPanel, numPanel, buttonPanel, myChoicePanel, myAdvicePanel, titlePanel,
	eastPanel;
	private JSplitPane sp;
	private JTextArea adviceArea;
	
}
