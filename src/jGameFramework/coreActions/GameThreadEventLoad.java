package jGameFramework.coreActions;

import jGameFramework.core.threadObjects.GameThreadHandler;
import jGameFramework.exceptions.ActionInvocationException;

import java.lang.reflect.Method;

/**
 * A specific GameEvent that will load a GameThread
 * from a file.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameThreadEventLoad extends GameThreadEvent {

    public GameThreadEventLoad(String saveFilePath) {
        super(getSaveGameStateMethod(), saveFilePath);
    }

    private static Method getSaveGameStateMethod(){
        try {
            return GameThreadHandler.class.getMethod("loadGame", String.class);
        } catch (NoSuchMethodException e) {
            throw new ActionInvocationException("loadGame", GameThreadHandler.class, e.getMessage());
        }
    }

}
