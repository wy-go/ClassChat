package school.client.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class OptionPaneControl extends JComboBox<String> {
	public OptionPaneControl(OptionPane pane) {	
		super(optionNums);
		optionPane = pane;
		setBounds(30, 40, 225, 25);
		addActionListener(new NumListener());
		}
	
	private class NumListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(getSelectedIndex() != 0) {
				optionNum = getSelectedIndex() + 1;
				optionPane.setNum(optionNum);
				optionPane.repaint();
			}
		}
	}
	
	private int optionNum;
	private OptionPane optionPane;
	static String[] optionNums = { "选项个数(2-10）", "2个选项","3个选项",
			"4个选项", "5个选项", "6个选项", "7个选项", "8个选项",
			"9个选项", "10个选项"};
}
