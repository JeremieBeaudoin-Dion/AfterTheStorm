package jGameFramework.coreActions;

import addResourceLoaderHere.GameThreadID;
import jGameFramework.core.threadObjects.GameThreadHandler;
import jGameFramework.exceptions.ActionInvocationException;

import java.lang.reflect.Method;

/**
 * A specific GameEvent that will create a new Thread to the game.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameThreadEventNew extends GameThreadEvent {

    public GameThreadEventNew(GameThreadID newThreadValue) {
        super(getNewGameStateMethod(), newThreadValue);
    }

    private static Method getNewGameStateMethod(){
        try {
            return GameThreadHandler.class.getMethod("newGameState", GameThreadID.class);
        } catch (NoSuchMethodException e) {
            throw new ActionInvocationException("newGameState", GameThreadHandler.class, e.getMessage());
        }
    }


}
