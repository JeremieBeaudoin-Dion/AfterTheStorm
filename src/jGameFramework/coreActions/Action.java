package jGameFramework.coreActions;

/**
 * An Action is an instance send by the InputHandler to the ActionHandler. It represents an input
 * from the user and will return an GameEvent that will help the ActionHandler to easily
 * influence the game with that action.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Action {

    protected GameEvent gameEvent;

    public Action(GameEvent gameEvent){
        this.gameEvent = gameEvent;
    }

    public boolean isDoable(){
        return true;
    }

    public GameEvent getAction(){
        return gameEvent;
    }

}
