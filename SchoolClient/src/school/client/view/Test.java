package school.client.view;


import javax.swing.JFrame;

public class Test extends JFrame{
		
		public Test() {
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			getContentPane().add(new OptionPane());
			pack();
			setVisible(true);
			
		}
		
		public static void main(String[] args) {
	
			new RegisterFrame();
		}
		
}
