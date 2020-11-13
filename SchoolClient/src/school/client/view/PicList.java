package school.client.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class PicList extends JPanel {
   private JLabel label;
   private JList list;

   public PicList (JLabel imageLabel)
   {
      label = imageLabel;

      String[] fileNames = { "0.jpg",
                             "1.jpg",
                             "2.jpg",
                             "3.jpg",
                             "4.jpg",
                             "5.jpg",
                             "6.jpg",
                             "7.jpg",
                             "8.jpg",
                             "9.jpg",
                             "10.jpg",
                             "11.jpg",
                             "12.jpg",
                             "13.jpg",
                             "14.jpg",
                             "15.jpg",
                             "16.jpg",
                             "17.jpg",
                             "18.jpg",
                             "19.jpg"};

      list = new JList (fileNames);
      list.addListSelectionListener (new ListListener());
      list.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);

      add (list);
      setBackground (Color.white);
   }

   private class ListListener implements ListSelectionListener
   {
      public void valueChanged (ListSelectionEvent event)
      {
         if (list.isSelectionEmpty())
            label.setIcon (null);
         else
         {
            String fileName = "src/profileImage/" + (String)list.getSelectedValue();
            ImageIcon image = new ImageIcon (fileName);
            image.setImage(image.getImage().getScaledInstance(220, 200, Image.SCALE_DEFAULT));
            label.setIcon (image);
         }
      }
   }
}
