package jGameFramework.coreActions;

import jGameFramework.core.threadObjects.GameThreadHandler;
import jGameFramework.exceptions.ActionInvocationException;

import java.lang.reflect.Method;

/**
 * A specific GameEvent that will exit the current GameThread.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameThreadEventQuit extends GameThreadEvent {

    public GameThreadEventQuit() {
        super(getQuitStateMethod());
    }

    private static Method getQuitStateMethod(){
        try {
            return GameThreadHandler.class.getMethod("quitCurrentState");
        } catch (NoSuchMethodException e) {
            throw new ActionInvocationException("quitCurrentState", GameThreadHandler.class, e.getMessage());
        }
    }

}
