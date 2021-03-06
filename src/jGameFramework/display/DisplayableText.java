package jGameFramework.display;

import jGameFramework.physicalObjects.Position;

import java.awt.*;

/**
 * A text is a String which can be show on the frame
 *
 * @author Jérémie Beaudoin-Dion
 */
public class DisplayableText extends Displayable {
	
	private String message;
	private Font font;
	private Paint paint;

	public DisplayableText(Position position, int depth, String message, Font font, Paint paint){
		super(position, new DisplayableDepth(depth));
		this.message = message;
		this.font = font;
		this.paint = paint;
	}

	public String getMessage() {
		return message;
	}

	public Font getFont() {
		return font;
	}
	
	public Paint getPaint() {
		return paint;
	}

}

