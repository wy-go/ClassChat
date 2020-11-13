package school.client.view;

import java.awt.Color;
import java.awt.Dimension;

public interface PanelConstants {

	/** The width of the business panels */
	public static final int PANEL_WIDTH = 350;
	
	/** The height of the small panels in the announcePanel and fileSharePanel */
	public static final int SMALL_PANEL_HEIGHT = 50;

	/** The width of the chat list */
	public static final int CHAT_LIST_WIDTH = 150;
	
	/** The width of head images of the chat list */
	public static int HEAD_WIDTH = 40;
	
	/** The size of labels of the chat list */
	Dimension CHAT_LIST_SIZE = new Dimension(CHAT_LIST_WIDTH, HEAD_WIDTH);
	
	/** The size of labels of the chat list */
	Dimension CLASSMATE_MESSAGE_SIZE = new Dimension(CHAT_LIST_WIDTH - HEAD_WIDTH, 30);
	
	/** The width of the chat area */
	public static final int CHAT_WIDTH = 200;
	
	/** The minimum size of the chat input area */
	Dimension CHAT_IN_MINIMUM_SIZE = new Dimension(CHAT_WIDTH, 100);
	
	/** The minimum size of the message area */
	Dimension CHAT_MESSAGE_MINIMUM_SIZE = new Dimension(CHAT_WIDTH, 450);
	
	/** The height of the chat input text area */
	public static final int CHAT_TEXT_HEIGHT = 500;
	
	/** The width that chat bar images should be displayed */
	public static final int CHAT_IMAGE_WIDTH = 25;

	/** The height that chat bar images should be displayed */
	public static final int CHAT_IMAGE_HEIGHT = 25;
	
	/** The width that file share upload and refresh images should be displayed */
	public static final int SHARE_IMAGE_WIDTH = 30;

	/** The height that file share upload and refresh images should be displayed */
	public static final int SHARE_IMAGE_HEIGHT = 30;
	
	/** The width that file share search images should be displayed */
	public static final int SEARCH_IMAGE_WIDTH = 17;

	/** The height that file share search images should be displayed */
	public static final int SEARCH_IMAGE_HEIGHT = 17;
	
	/** The width that file share download images should be displayed */
	public static final int DOWNLOAD_IMAGE_WIDTH = 20;

	/** The height that file share download images should be displayed */
	public static final int DOWNLOAD_IMAGE_HEIGHT = 20;
	
	
	public static final Color WHITE_SMOKE = new Color(245,245,245);
	public static final Color SHANDA_RED = new Color(156, 12, 19);
	public static final Color ALICE_BLUE = new Color(240, 248, 255);
	public static final Color LIGHT_SKY_BLUE = new Color(135, 206, 250);
	public static final Color DEEP_SKY_BLUE = new Color(0, 191, 255);
	public static final Color SKY_BLUE = new Color(135, 206, 235);
	public static final Color DODGER_BLUE = new Color(30, 144, 255);
	public static final Color CORN_FLOWER_BLUE = new Color(0, 191, 255);
	public static final Color STEEL_BLUE = new Color(70, 130, 180);
	public static final Color PALE_VIOLET_RED = new Color(219, 112, 147);
}
