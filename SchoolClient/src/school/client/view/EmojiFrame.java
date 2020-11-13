package school.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class EmojiFrame extends JFrame implements MouseListener {
    public EmojiFrame(ChatArea chatArea) {
        this.chatArea = chatArea;
        setUndecorated(true);
        setResizable(false);
        setAlwaysOnTop(true);
        con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.WHITE);
        File file = new File("src/emoji");
        iconList = file.list();
        iconLabels = new JLabel[iconList.length];
        for(int i = 0; i < iconList.length; i++) {
        	    ImageIcon icon = new ImageIcon("src/emoji/" + iconList[i]);
            icon.setImage(icon.getImage().getScaledInstance(ICON_WIDTH, ICON_WIDTH, Image.SCALE_DEFAULT));
            iconLabels[i] = new JLabel(icon);
            iconLabels[i].setBounds(ICON_WIDTH * (i % 3) + 2, ICON_WIDTH * (i / 3) + 2, ICON_WIDTH, ICON_WIDTH);
            iconLabels[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            iconLabels[i].addMouseListener(this);
            add(iconLabels[i]);
        }
        setSize(ICON_WIDTH * 3 + 4, ICON_WIDTH * 2 + 4);
        setVisible(true);
        JLabel emojiLabel = chatArea.getEmojiLabel();
        setLocationRelativeTo(emojiLabel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addMouseListener(this);
    }
    
    public void mouseClicked(MouseEvent e) {
        for(int i = 0; i < iconList.length; i++) {
            if(e.getSource() == iconLabels[i]) {
            		chatArea.getChatInText().insertIcon(iconLabels[i].getIcon());
            		dispose();
            		break;
            }
        }
    }
   
    public void mouseEntered(MouseEvent e) {
        for(int i = 0; i < iconLabels.length; i++) {
            if(e.getSource() == iconLabels[i]) {
            		iconLabels[i].setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1));
            }
        }
    }
 
    public void mouseExited(MouseEvent e) {
        for(int i = 0; i < iconLabels.length; i++) {
            if(e.getSource() == iconLabels[i]) {
            		iconLabels[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
            }
        }
      	if(e.getSource() == this) {
      		dispose();
      	}
    }
 
    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}
    
    private JLabel[] iconLabels;
    private String[] iconList;
    private ChatArea chatArea;
    private Container con;
    
    public static final Color DEEP_SKY_BLUE = new Color(0, 191, 255);
	public static final Color SKY_BLUE = new Color(135, 206, 235);
	public static final Color DODGER_BLUE = new Color(30, 144, 255);
	public static final Color CORN_FLOWER_BLUE = new Color(0, 191, 255);
	public static final Color STEEL_BLUE = new Color(70, 130, 180);
    public static final Color LIGHT_SKY_BLUE = new Color(135, 206, 250);
    
    /** The width and height of icons */
    public static final int ICON_WIDTH = 25;
    
    /** The color of the icon border */
    public static final Color BORDER_COLOR = LIGHT_SKY_BLUE;
}
