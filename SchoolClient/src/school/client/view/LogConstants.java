package school.client.view;
/*
 * File: LogConstants.java
 * --------------------------------
 * This file declares several constants that are shared by the
 * different modules in the log page.  Any class that implements
 * this interface can use these constants.
 */

import java.awt.Color;

public interface LogConstants {

	/** The width of the application window */
	public static final int APPLICATION_WIDTH = 800;

	/** The height of the application window */
	public static final int APPLICATION_HEIGHT = 500;

	/** The width of the LogCenterPanel */
	public static final int CENTER_WIDTH = 600;
	
	/** The width of the LogCenterPanel */
	public static final int CENTER_HEIGHT = 300;
	
	/** The number of pixels in the vertical margin between the top 
	 *  of the logCenterPanel and the top of the window and the number of 
	 *  pixels in the horizontal margin between the left side of the 
	 *  logCenterPanel and the lest side of the window*/	
	public static final int TOP_LEFT_MARGIN = 100;	
	
	/** Name of font used to display the welcome label in LoginPanel */
	public static final String WELCOME_FONT_NAME = "Baoli SC";
	
	/** Size of font used to display the welcome label in LoginPanel */
	public static final int WELCOME_FONT_SIZE = 25;
	
	/** Number of characters for each of the text input fields */
	public static final int TEXT_FIELD_SIZE = 200;
	
	/** Thickness of the border of the LogCenterPabel */
	public static final int BORDER_THICKNESS = 2;
	
	/** The width that log images should be displayed */
	public static final int IMAGE_WIDTH = 20;

	/** The height that log images should be displayed */
	public static final int IMAGE_HEIGHT = 20;
	
	/** The number of pixels in the horizontal margin between the 
	 *  left side of the log test field  and the left side of the
	 *  LogCenterPanel */	
	public static final int TEXT_LEFT_MARGIN = 370;	
	
	/** The number of pixels in the vertical margin between the 
	 *  top of the first log test field and the top of the LogCenterPanel */	
	public static final int TEXT_TOP_MARGIN_ONE = 100;	
	
	/** The number of pixels in the vertical margin between the 
	 *  top of the second log test field and the top of the LogCenterPanel */	
	public static final int TEXT_TOP_MARGIN_TWO = 170;	
	
	/** The width that ID label and password label should be displayed */
	public static final int ID_PASSWORD_LABEL_WIDTH = 70;
	
	/** The width of the buttons in the log page */
	public static final int BUTTON_WIDTH = 95;
	
	/** The height of the components except prompt that are displayed
	 *  in the log page */	
	public static final int COMPONENT_HEIGHT = 30;	
	
	/** Size of font used to display the IDLabel, passwordLabel, logIn button,
	 *  register button in LogCenterPanel */
	public static final int COMPONEMT_FONT_SIZE = 15;
	
	/** New color '山大红' */
	public static final Color SHANDA_RED = new Color(156, 12, 19);

}

