package school.client.view;

import java.awt.*;
import javax.swing.*;

public class PickImage {
    public PickImage() {
    	JFrame frame = new JFrame("Pick Profile Image");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel imageLabel = new JLabel();
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);
        imagePanel.setBackground(Color.white);

        PicList imageList = new PicList(imageLabel);

        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, imageList, imagePanel);

        sp.setOneTouchExpandable (true);

        frame.getContentPane().add (sp);
        frame.pack();
        frame.setVisible(true);
    }
 
}
