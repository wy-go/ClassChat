package school.client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import school.client.tools.ClientFileUploadThread;
import school.common.FileInfo;
import school.common.User;

public class FileSharePanel extends JPanel implements MouseListener, PanelConstants{
	public FileSharePanel(User u) {
		user = u;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		toolPanel = new JPanel();
		toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.X_AXIS));
		toolPanel.setBackground(Color.white);
		headLabel = new JLabel("文件共享");
		headLabel.setFont(new Font("", Font.PLAIN, 17));
		headLabel.setForeground(Color.gray);
		upload = new ImageIcon("src/school/client/view/upload.jpg");
		upload.setImage(upload.getImage().getScaledInstance(SHARE_IMAGE_WIDTH, SHARE_IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		uploadLabel = new JLabel(upload);
		uploadLabel.addMouseListener(new uploadListener());
		refresh = new ImageIcon("src/school/client/view/refresh.jpg");
		refresh.setImage(refresh.getImage().getScaledInstance(SHARE_IMAGE_WIDTH, SHARE_IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		refreshLabel = new JLabel(refresh);
		search = new ImageIcon("src/school/client/view/search.jpg");
		search.setImage(search.getImage().getScaledInstance(SEARCH_IMAGE_WIDTH, SEARCH_IMAGE_HEIGHT, Image.SCALE_DEFAULT));
		searchLabel = new JLabel(search);
		searchField = new JTextField(10);
		toolPanel.add(headLabel);
		toolPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		toolPanel.add(uploadLabel);
		toolPanel.add(refreshLabel);
		toolPanel.add(Box.createRigidArea(new Dimension(450, 0)));
		toolPanel.add(searchLabel);
		toolPanel.add(searchField);
		
		filePanel = new JPanel();
		filePanel.setLayout(new BoxLayout(filePanel, BoxLayout.Y_AXIS));
		for(int i = 0; i < fileNum; i++) {
			file[i] = new File("文件名", "time");
			filePanel.add(file[i]);
		}
		add(toolPanel);
		add(new JScrollPane(filePanel));
	}
	private class File extends JPanel implements MouseListener{
		public File(String title, String time) {
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setPreferredSize(new Dimension(PANEL_WIDTH, SMALL_PANEL_HEIGHT));
			setBackground(Color.white);
			setBorder(new LineBorder(WHITE_SMOKE, 1));
			titleLabel = new JLabel(title);
			titleLabel.setFont(new Font("", Font.PLAIN, 16));
			titleLabel.addMouseListener(this);
			timeLabel = new JLabel(time);
			westPanel = new JPanel();
			westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
			westPanel.setBackground(Color.white);
			westPanel.add(titleLabel);
			westPanel.add(Box.createVerticalGlue());
			westPanel.add(timeLabel);
			
			add(westPanel);
			add(Box.createHorizontalGlue());
			
			download = new ImageIcon("src/clientView/download.jpg");
			download.setImage(download.getImage().getScaledInstance(DOWNLOAD_IMAGE_WIDTH, DOWNLOAD_IMAGE_HEIGHT, Image.SCALE_DEFAULT));
			downloadLabel = new JLabel(download);
			downloadLabel.addMouseListener(this);
			
			add(downloadLabel);
			
		}
		
		public void mouseClicked(MouseEvent e) {}
		
		public void mousePressed(MouseEvent e) {}
		
		public void mouseReleased(MouseEvent e) {}
		
		public void mouseEntered(MouseEvent e) {
			setBackground(WHITE_SMOKE);
			westPanel.setBackground(WHITE_SMOKE);
		}
		
		public void mouseExited(MouseEvent e) {
			setBackground(Color.white);
			westPanel.setBackground(Color.white);
		}
		
		private ImageIcon download;
		private JLabel titleLabel, timeLabel, downloadLabel; 
		private JPanel westPanel;
		
	}
	
	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
	
	public class uploadListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			JFileChooser jFileChooser = new JFileChooser();
            if(jFileChooser.showOpenDialog(FileSharePanel.this) == jFileChooser.APPROVE_OPTION) {
                java.io.File file = jFileChooser.getSelectedFile();
                try {
                	    Socket socket = new Socket(InetAddress.getLocalHost(), 8000);
                		Thread thread = new ClientFileUploadThread(socket, file);
                		thread.start();
                    String filename = file.getName();
                    String name = filename.substring(0, filename.lastIndexOf("."));
                    String suffix = filename.substring(filename.lastIndexOf("."), filename.length());
                    FileInfo fileInfo = new FileInfo(user.getStuName(), name, suffix, file.length());
                    
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(fileInfo);
                    oos.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
		}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}
		
	}
	private int fileNum = 20;
	private File[] file = new File[fileNum];
	private ImageIcon upload, search, refresh;
	private JLabel headLabel, uploadLabel, refreshLabel, searchLabel;
	private JPanel toolPanel, filePanel;
	private JTextField searchField;
	private User user;
	
}




