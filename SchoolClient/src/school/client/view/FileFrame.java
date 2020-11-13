package school.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class FileFrame extends JFrame implements MouseListener {
    public FileFrame(ChatArea chatArea) {
        this.chatArea = chatArea;
        setUndecorated(true);
        setResizable(false);
        setAlwaysOnTop(true);
        
        fileLabel = new JLabel(" 发送文件");
        fileLabel.setBounds(3, 4, 61, 20);
        fileLabel.setOpaque(true);
        fileLabel.setBackground(Color.white);
        fileLabel.addMouseListener(this);
        picLabel = new JLabel(" 发送图片");
        picLabel.setBounds(3, 24, 61, 20);
        picLabel.setOpaque(true);
        picLabel.setBackground(Color.white);
        picLabel.addMouseListener(this);
        con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.white);
        con.add(fileLabel);
        con.add(picLabel);
        addMouseListener(this);
        
        setSize(67, 48);
        setVisible(true);
        JLabel fileTransLabel = chatArea.getFileTransLabel();
        setLocationRelativeTo(fileTransLabel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void mouseClicked(MouseEvent e) {
    	 	if(e.getSource() == fileLabel) {
     		//打开文本选择器
    	 	} else {
    	 		//打开文本选择器
    	 	}
    	 	dispose();
    }
    
    public void mouseEntered(MouseEvent e) {
         if(e.getSource() == fileLabel) {
        	 	fileLabel.setBackground(LABEL_BACK);
        	 	fileLabel.setForeground(Color.white);
         } else {
        	    picLabel.setBackground(LABEL_BACK);
        	    picLabel.setForeground(Color.white);
         }
    }
 
    public void mouseExited(MouseEvent e) {
	    	if(e.getSource() == fileLabel) {
	    	 	fileLabel.setBackground(Color.white);
	    	 	fileLabel.setForeground(Color.black);
	     } else if(e.getSource() == picLabel){
	    	    picLabel.setBackground(Color.white);
	    	    picLabel.setForeground(Color.black);
	     }
	    	if(e.getSource() == this) {
	    	 	dispose();
	    }
    }
 
    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}
    
    private JLabel fileLabel, picLabel;
    private ChatArea chatArea;
    private Container con;
    
    public static final Color DEEP_SKY_BLUE = new Color(0, 191, 255);
	public static final Color SKY_BLUE = new Color(135, 206, 235);
	public static final Color DODGER_BLUE = new Color(30, 144, 255);
	public static final Color CORN_FLOWER_BLUE = new Color(0, 191, 255);
	public static final Color STEEL_BLUE = new Color(70, 130, 180);
    public static final Color LIGHT_SKY_BLUE = new Color(135, 206, 250);
 
    /** The color of the label background */
    public static final Color LABEL_BACK = DODGER_BLUE;
}
