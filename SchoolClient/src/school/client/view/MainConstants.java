package school.client.view;
/*
 * File: MainConstants.java
 * --------------------------------
 * This file declares several constants that are shared by the
 * different modules in the main page.  Any class that implements
 * this interface can use these constants.
 */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;

public interface MainConstants {

	/** The width of the application window */
	public static final int APPLICATION_WIDTH = 860;

	/** The height of the application window */
	public static final int APPLICATION_HEIGHT = 640;

	/** The width of the WestPanel */
	public static final int WEST_WIDTH = 60;
	
	/** The minimum size of the east panels */
	Dimension eastMinimumSize = new Dimension(180, 200);
	
	/** The width that chat bar images should be displayed */
	public static final int IMAGE_WIDTH = 34;

	/** The height that chat bar images should be displayed */
	public static final int IMAGE_HEIGHT = 34;
	
	public static final Color WHITE_SMOKE = new Color(245,245,245);
	public static final Color SHANDA_RED = new Color(156, 12, 19);
	public static final Color LIGHT_SKY_BLUE = new Color(135, 206, 250);
	public static final Color DEEP_SKY_BLUE = new Color(0, 191, 255);
	public static final Color SKY_BLUE = new Color(135, 206, 235);
	public static final Color DODGER_BLUE = new Color(30, 144, 255);
	public static final Color CORN_FLOWER_BLUE = new Color(0, 191, 255);
	public static final Color STEEL_BLUE = new Color(70, 130, 180);
	public static final Color PALE_VIOLET_RED = new Color(219, 112, 147);
	public static final LineBorder CHOSEN_BORDER = new LineBorder(SHANDA_RED, 1);
}

