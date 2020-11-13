package school.client.view;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import school.client.tools.ManageClientConServerThread;
import school.common.Message;
import school.common.MessageType;
import school.common.User;

public class ChatArea extends JSplitPane implements ActionListener, PanelConstants{
	public ChatArea(String ownerName, String classmateName) {
		this.ownerName = ownerName;
		this.classmateName = classmateName;
		setOrientation(VERTICAL_SPLIT);
	
		messageText = new JTextPane();
		messageText.setEditable(false);
		messageBoard = new JScrollPane(messageText);
		messageBoard.setMinimumSize(CHAT_MESSAGE_MINIMUM_SIZE);
		messageBoard.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		chatPanel = new JPanel();
		chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
		chatPanel.setMinimumSize(CHAT_IN_MINIMUM_SIZE);
		chatBar = new JPanel();
		chatBar.setLayout(new BoxLayout(chatBar, BoxLayout.X_AXIS));
		chatBar.setBackground(Color.white);
		chatBar.setPreferredSize(new Dimension(CHAT_WIDTH, CHAT_IMAGE_HEIGHT));
		emoji = new ImageIcon("src/school/client/view/expression.jpg");
		emoji.setImage(emoji.getImage().getScaledInstance(CHAT_IMAGE_WIDTH, CHAT_IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		emojiLabel = new JLabel(emoji);
		emojiLabel.addMouseListener(new BarListener());
		scrShot = new ImageIcon("src/school/client/view/screenShot.jpg");
		scrShot.setImage(scrShot.getImage().getScaledInstance(CHAT_IMAGE_WIDTH, CHAT_IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		scrShotLabel = new JLabel(scrShot);
		scrShotLabel.addMouseListener(new BarListener());
	    fileTrans = new ImageIcon("src/school/client/view/fileTransfer.jpg");
		fileTrans.setImage(fileTrans.getImage().getScaledInstance(CHAT_IMAGE_WIDTH, CHAT_IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		fileTransLabel = new JLabel(fileTrans);
		fileTransLabel.addMouseListener(new BarListener());
		paint = new ImageIcon("src/school/client/view/paint.jpg");
		paint.setImage(paint.getImage().getScaledInstance(CHAT_IMAGE_WIDTH, CHAT_IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		paintLabel = new JLabel(paint);
		paintLabel.addMouseListener(new BarListener());
		sendButton = new JButton("     发送     ");
		sendButton.setMnemonic('S');
		sendButton.addActionListener(this);
		chatBar.add(emojiLabel);
		chatBar.add(Box.createRigidArea(new Dimension(5, 0)));
		chatBar.add(scrShotLabel);
		chatBar.add(Box.createRigidArea(new Dimension(5, 0)));
		chatBar.add(fileTransLabel);
		chatBar.add(Box.createRigidArea(new Dimension(5, 0)));
		chatBar.add(paintLabel);
		chatBar.add(Box.createHorizontalGlue());
		chatBar.add(sendButton);
		chatInText = new JTextPane();
		chatInText.setPreferredSize(new Dimension(CHAT_WIDTH, CHAT_TEXT_HEIGHT));
		chatInPane = new JScrollPane(chatInText);
		chatInPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPanel.add(chatBar);
		chatPanel.add(chatInPane);
		
		setTopComponent(messageBoard);
		setBottomComponent(chatPanel);
	}

	public String getClassmateName() {
		return classmateName;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sendButton) {
			Message m = new Message();
			m.setMesType(MessageType.COMMON_MESSAGE);
			System.out.println("->COMMON_MESSAGE");
			m.setSender(ownerName);
			m.setGetter(classmateName);
			m.setDoc(chatInText.getStyledDocument());
			Date date = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss" );
	        String time = sdf.format(date);
			m.setTime(time);
			try {
				appendView(m);
				try {
					ObjectOutputStream oos = new ObjectOutputStream
					(ManageClientConServerThread.getClientConServerThread(ownerName).getS().getOutputStream());
					oos.writeObject(m);
					oos.flush();
				
				} catch(IOException e1) {
					e1.printStackTrace();
				}
				chatInText.setText("");
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public JTextPane getChatInText() {
		return chatInText;
	}
	
	public JLabel getEmojiLabel() {
		return emojiLabel;
	}
	
	public JLabel getFileTransLabel() {
		return fileTransLabel;
	}
	
	public void appendView(Message m) throws BadLocationException {
		 StyledDocument recDoc = messageText.getStyledDocument(); 
		 SimpleAttributeSet as = new SimpleAttributeSet();
		 String str = m.getSender() + "    " + m.getTime() + "\n";
		 recDoc.insertString(recDoc.getLength(), str, as);
		 int end = 0;
		 StyledDocument sd = m.getDoc();
		// System.out.print(sd.getLength());
		 while(end < sd.getLength()) {
			 Element e = sd.getCharacterElement(end);
			 SimpleAttributeSet as1 = new SimpleAttributeSet();
	         StyleConstants.setForeground(as1, StyleConstants.getForeground(e.getAttributes()));
	         StyleConstants.setFontSize(as1, StyleConstants.getFontSize(e.getAttributes()));
	         StyleConstants.setFontFamily(as1, StyleConstants.getFontFamily(e.getAttributes()));
			 str = e.getDocument().getText(end, e.getEndOffset() - end);
			 if("icon".equals(e.getName())) {
				recDoc.insertString(recDoc.getLength(), str, e.getAttributes());
	         }else {
	        	 	recDoc.insertString(recDoc.getLength(), str, new SimpleAttributeSet());
	         }
			 end = e.getEndOffset();
		 }
		 recDoc.insertString(recDoc.getLength(), "\n", as);
		 messageText.setCaretPosition(recDoc.getLength());
	}

	/*private boolean isClassChat() {
		return (owner.getStuClass().getClassID() == classmateName);
	}
	*/
	
	private class BarListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == emojiLabel) {
				new EmojiFrame(ChatArea.this);
			} else if (e.getSource() == scrShotLabel) {
				
			} else if(e.getSource() == fileTransLabel){
				new FileFrame(ChatArea.this);
			} else {
				
			}
		}

		public void mousePressed(MouseEvent e) {}
		
		public void mouseReleased(MouseEvent e) {}
		
		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == emojiLabel) {
				new EmojiFrame(ChatArea.this);
			} else if (e.getSource() == scrShotLabel) {
				
			} else if(e.getSource() == fileTransLabel){
				new FileFrame(ChatArea.this);
			} else {
				
			}
		}

		public void mouseExited(MouseEvent e) {}
		
	}
	
	private JPanel chatPanel, chatBar;
    private JLabel emojiLabel, scrShotLabel, fileTransLabel, paintLabel;
    private JButton sendButton;
	private ImageIcon emoji, scrShot, fileTrans, paint;
	private JScrollPane chatInPane, messageBoard;
	private JTextPane chatInText, messageText;
	private String ownerName, classmateName;
}
