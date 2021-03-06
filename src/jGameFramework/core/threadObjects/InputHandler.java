package jGameFramework.core.threadObjects;

import jGameFramework.collections.InputActionKeyMap;
import jGameFramework.core.MouseHandler;
import jGameFramework.physicalObjects.Position;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * The InputHandler class handles input from the player and converts it to
 * actionOfGameHere that the actionHandler can handle.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class InputHandler {

	private ActionHandler actionHandler;

	// Stores what to do with KeyEvents and MouseEvents
	private InputActionKeyMap inputActionKeyMap;

	/**
	 * Constructor
	 *
	 * @param inputActionKeyMap: The binds between each KeyEvent and
	 */
	InputHandler(InputActionKeyMap inputActionKeyMap, ActionHandler actionHandler) {
		this.actionHandler = actionHandler;

		if (inputActionKeyMap == null){
			this.inputActionKeyMap = new InputActionKeyMap(null, null,null,null);
		} else {
			this.inputActionKeyMap = inputActionKeyMap;
		}

	}

	/**
	 * Called when a key is pressed by the KeyListener
	 * @param event KeyEvent sent by the component
	 */
	public void keyPressed(KeyEvent event) {
		actionHandler.doAction(inputActionKeyMap.getKeyDown(event.getKeyCode()));
	}

	/**
	 * Called when a key is released by the KeyListener
	 * @param event KeyEvent sent by the component
	 */
	public void keyReleased(KeyEvent event) {
		actionHandler.doAction(inputActionKeyMap.getKeyRelease(event.getKeyCode()));
	}

	public void mousePressed(MouseEvent mouseEvent, MouseHandler.MouseClick clickValue) {
		actionHandler.doAction(inputActionKeyMap.getMouseDown(clickValue),
				MouseHandler.getMousePositionRelativeToScreen(new Position(mouseEvent.getX(), mouseEvent.getY())));
	}

	public void mouseReleased(MouseEvent mouseEvent, MouseHandler.MouseClick clickValue) {
		actionHandler.doAction(inputActionKeyMap.getMouseRelease(clickValue),
				MouseHandler.getMousePositionRelativeToScreen(new Position(mouseEvent.getX(), mouseEvent.getY())));
	}
}
