package jGameFramework.core;

import addResourceLoaderHere.GameInformation;
import jGameFramework.core.threadObjects.GameThreadHandler;
import jGameFramework.physicalObjects.Position;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * A Handler class when the player resize the frame.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class FrameResizeHandler extends ComponentAdapter {

    private GameThreadHandler gameThreadHandler;
    private Position lastSize;

    public FrameResizeHandler(GameThreadHandler gameThreadHandler) {
        this.gameThreadHandler = gameThreadHandler;

        lastSize = new Position(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
    }

    /**
     * A method called when the JFrame is resized
     */
    public void componentResized(ComponentEvent e) {
        Position newScreenSize = new Position(e.getComponent().getSize());

        gameThreadHandler.resize(lastSize, newScreenSize);
        GameInformation.resize(newScreenSize);
        Game.resize(newScreenSize);

        lastSize = newScreenSize;
    }

}
