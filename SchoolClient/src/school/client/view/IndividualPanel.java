package school.client.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import school.common.User;

public class IndividualPanel extends JPanel implements PanelConstants{
	public IndividualPanel(User student, ListPanel hostPanel) {
		name = student.getStuName();
		position = student.getPositon();
		
		nameLabel = new JLabel(name);
		nameLabel.setFont(new Font("", Font.PLAIN, 15));
		nameLabel.setForeground(Color.black);
		positionLabel = new JLabel(position);
		positionLabel.setFont(new Font("", Font.PLAIN, 15));
		positionLabel.setForeground(Color.black);
		
	}
	private JLabel nameLabel, positionLabel;
	private String name, position;
 }
