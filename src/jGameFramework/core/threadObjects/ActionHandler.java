package jGameFramework.core.threadObjects;

import jGameFramework.core.ImageHandler;
import jGameFramework.coreActions.Action;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.physicalObjects.Camera;

import java.util.List;

/**
 * Receives Actions from the InputHandler and sends
 * an GameEvent to the correct class.
 *
 * The only unimplemented method is updateAllActions() which
 * should call the method update() to all game dependent
 * actions.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ActionHandler {

    private ObjectHandler objectHandler;
    private GameThreadHandler gameThreadHandler;

    /**
     * Constructor
     */
    public ActionHandler(GameThreadHandler gameThreadHandler, ObjectHandler objectHandler) {
        this.gameThreadHandler = gameThreadHandler;
        this.objectHandler = objectHandler;
    }

    /**
     * Sends an action to do in the game
     */
    public void doAction(Action currentAction) {
        if (currentAction.isDoable()) {
            handleActionEvent(currentAction.getAction());
        }
    }

    @SuppressWarnings("unchecked")
    private void handleActionEvent(GameEvent gameEvent) {
        if (gameEvent.getClassValue() == ImageHandler.class) {

        } else if (gameEvent.getClassValue() == ObjectHandler.class) {
            gameEvent.doAction(objectHandler);

        } else if (gameEvent.getClassValue() == GameThreadHandler.class) {
            gameEvent.doAction(gameThreadHandler);

        } else if (gameEvent.getClassValue() == Camera.class) {
            gameEvent.doAction(objectHandler.getCamera());

        } else {
            gameEvent.doAction(objectHandler.getObject(gameEvent.getClassValue()));
        }
    }

    public void doAction(Action currentAction, Object parameterValue) {
        if (currentAction.isDoable()) {
            handleActionEvent(currentAction.getAction(), parameterValue);
        }
    }

    @SuppressWarnings("unchecked")
    private void handleActionEvent(GameEvent gameEvent, Object parameterValue) {
        if (gameEvent.getClassValue() == ImageHandler.class) {

        } else if (gameEvent.getClassValue() == ObjectHandler.class) {
            gameEvent.doAction(objectHandler, parameterValue);

        } else if (gameEvent.getClassValue() == GameThreadHandler.class) {
            gameEvent.doAction(gameThreadHandler, parameterValue);

        } else if (gameEvent.getClassValue() == Camera.class) {
            gameEvent.doAction(objectHandler.getCamera(), parameterValue);

        } else {
            gameEvent.doAction(objectHandler.getObject(gameEvent.getClassValue()), parameterValue);
        }
    }

    /**
     * Called every frame
     */
    public void update() {
        handleActionsFromObjectHandler();
    }

    private void handleActionsFromObjectHandler() {
        List<GameEvent> actionsToDo = objectHandler.getAllCurrentActions();

        for (GameEvent action : actionsToDo) {
            handleActionEvent(action);
        }
    }
}
