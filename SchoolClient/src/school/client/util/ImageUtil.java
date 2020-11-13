package school.client.util;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtil {
    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    public static ImageIcon getRoundImageIcon(Image img) {
        try {
            BufferedImage master = toBufferedImage(img);
            int diameter = Math.min(master.getWidth(), master.getHeight());

            // 创建一个圆形遮罩
            BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = mask.createGraphics();
            RendererUtil.applyQualityRenderingHints(g2d);
            g2d.fillOval(0, 0, diameter - 1, diameter - 1);
            g2d.dispose();

            // 开始绘制
            BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
            g2d = masked.createGraphics();
            RendererUtil.applyQualityRenderingHints(g2d);

            int x = (diameter - master.getWidth()) / 2;
            int y = (diameter - master.getHeight()) / 2;

            g2d.drawImage(master, x, y, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
            g2d.drawImage(mask, 0, 0, null);
            g2d.dispose();
            return new ImageIcon(masked);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
