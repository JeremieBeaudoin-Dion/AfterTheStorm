package jGameFramework.coreActions;

import jGameFramework.core.threadObjects.GameThreadHandler;
import jGameFramework.exceptions.ActionInvocationException;

import java.lang.reflect.Method;

/**
 * A specific GameEvent that will stop the desired music
 * according to its id.
 *
 * If the music is not playing, it will simply be ignored.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class GameEventStopMusic extends GameThreadEvent {

    public GameEventStopMusic(String musicID) {
        super(getStopMusicMethod(), musicID);
    }

    private static Method getStopMusicMethod(){
        try {
            return GameThreadHandler.class.getMethod("stopMusic", String.class);
        } catch (NoSuchMethodException e) {
            throw new ActionInvocationException("stopMusic", GameThreadHandler.class, e.getMessage());
        }
    }


}
