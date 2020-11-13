package school.client.view;

import java.awt.Color;
import java.awt.Dimension;

public interface WindowConstants {
	
	/** The width of the application window */
	public static final int WINDOW_WIDTH = 680;

	/** The height of the application window */
	public static final int WINDOW_HEIGHT = 640;
	
	/** The width of the document area */
	public static final int DOCUMENT_WIDTH = 420;
	
	/** The width of the comment area */
	public static final int COMMENT_WIDTH = WINDOW_WIDTH - DOCUMENT_WIDTH;
	
	/** The minimum size of the advice input area */
	Dimension ADVICE_MINIMUM_SIZE = new Dimension(WINDOW_WIDTH, 110);
	
	/** The height of the advice text area */
	public static final int ADVICE_AREA_HEIGHT = 550;
	
	/** The height of the advice text area */
	public static final int AGREE_PANEL_HEIGHT = 20;
	
	/** The height of the option panels of vote window*/
	public static final int OPTION_HEIGHT = 50;
	
	public static final Color WHITE_SMOKE = new Color(245,245,245);
	public static final Color DODGER_BLUE = new Color(30, 144, 255);
}
