package addResourceLoaderHere;

import jGameFramework.core.MouseHandler;
import jGameFramework.core.threadObjects.ObjectHandler;
import jGameFramework.coreActions.Action;
import jGameFramework.coreActions.ActionTimed;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.physicalObjects.PhysicalObjectMoving;
import jGameFramework.physicalObjects.Position;
import jGameFramework.physicalObjects.Velocity;

import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * A helper method that returns useful InputActionKeyMap
 *
 * @author Jérémie Beaudoin-Dion
 */
class ActionMapHelper {

    static HashMap<Integer, Action> getAllArrowPushActions(Class<? extends PhysicalObjectMoving> playerClass) {
        HashMap<Integer, Action> actionPushMap = new HashMap<>();

        try {
            Action playerGoingUp = new Action(new GameEvent<>(playerClass, playerClass.getMethod("addToMovingOrders", Velocity.Direction.class), Velocity.Direction.UP));
            actionPushMap.put(KeyEvent.VK_UP, playerGoingUp);

            Action playerGoingDown = new Action(new GameEvent<>(playerClass, playerClass.getMethod("addToMovingOrders", Velocity.Direction.class), Velocity.Direction.DOWN));
            actionPushMap.put(KeyEvent.VK_DOWN, playerGoingDown);

            Action playerGoingLeft = new Action(new GameEvent<>(playerClass, playerClass.getMethod("addToMovingOrders", Velocity.Direction.class), Velocity.Direction.LEFT));
            actionPushMap.put(KeyEvent.VK_LEFT, playerGoingLeft);

            Action playerGoingRight = new Action(new GameEvent<>(playerClass, playerClass.getMethod("addToMovingOrders", Velocity.Direction.class), Velocity.Direction.RIGHT));
            actionPushMap.put(KeyEvent.VK_RIGHT, playerGoingRight);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return actionPushMap;
    }

    static HashMap<Integer, Action> getAllArrowReleaseActions(Class<? extends PhysicalObjectMoving> playerClass) {
        HashMap<Integer, Action> actionReleaseMap = new HashMap<>();

        try {
            Action playerNotUp = new Action(new GameEvent<>(playerClass, playerClass.getMethod("removeToMovingOrders", Velocity.Direction.class), Velocity.Direction.UP));
            actionReleaseMap.put(KeyEvent.VK_UP, playerNotUp);

            Action playerNotDown = new Action(new GameEvent<>(playerClass, playerClass.getMethod("removeToMovingOrders", Velocity.Direction.class), Velocity.Direction.DOWN));
            actionReleaseMap.put(KeyEvent.VK_DOWN, playerNotDown);

            Action playerNotLeft = new Action(new GameEvent<>(playerClass, playerClass.getMethod("removeToMovingOrders", Velocity.Direction.class), Velocity.Direction.LEFT));
            actionReleaseMap.put(KeyEvent.VK_LEFT, playerNotLeft);

            Action playerNotRight = new Action(new GameEvent<>(playerClass, playerClass.getMethod("removeToMovingOrders", Velocity.Direction.class), Velocity.Direction.RIGHT));
            actionReleaseMap.put(KeyEvent.VK_RIGHT, playerNotRight);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return actionReleaseMap;
    }

    static HashMap<Integer, Action> getAllWASDPushActions(Class<? extends PhysicalObjectMoving> playerClass) {
        HashMap<Integer, Action> actionPushMap = new HashMap<>();

        try {
            Action playerGoingUp = new Action(new GameEvent<>(playerClass, playerClass.getMethod("addToMovingOrders", Velocity.Direction.class), Velocity.Direction.UP));
            actionPushMap.put(KeyEvent.VK_W, playerGoingUp);

            Action playerGoingDown = new Action(new GameEvent<>(playerClass, playerClass.getMethod("addToMovingOrders", Velocity.Direction.class), Velocity.Direction.DOWN));
            actionPushMap.put(KeyEvent.VK_S, playerGoingDown);

            Action playerGoingLeft = new Action(new GameEvent<>(playerClass, playerClass.getMethod("addToMovingOrders", Velocity.Direction.class), Velocity.Direction.LEFT));
            actionPushMap.put(KeyEvent.VK_A, playerGoingLeft);

            Action playerGoingRight = new Action(new GameEvent<>(playerClass, playerClass.getMethod("addToMovingOrders", Velocity.Direction.class), Velocity.Direction.RIGHT));
            actionPushMap.put(KeyEvent.VK_D, playerGoingRight);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return actionPushMap;
    }

    static HashMap<Integer, Action> getAllWASDReleaseActions(Class<? extends PhysicalObjectMoving> playerClass) {
        HashMap<Integer, Action> actionReleaseMap = new HashMap<>();

        try {
            Action playerNotUp = new Action(new GameEvent<>(playerClass, playerClass.getMethod("removeToMovingOrders", Velocity.Direction.class), Velocity.Direction.UP));
            actionReleaseMap.put(KeyEvent.VK_W, playerNotUp);

            Action playerNotDown = new Action(new GameEvent<>(playerClass, playerClass.getMethod("removeToMovingOrders", Velocity.Direction.class), Velocity.Direction.DOWN));
            actionReleaseMap.put(KeyEvent.VK_S, playerNotDown);

            Action playerNotLeft = new Action(new GameEvent<>(playerClass, playerClass.getMethod("removeToMovingOrders", Velocity.Direction.class), Velocity.Direction.LEFT));
            actionReleaseMap.put(KeyEvent.VK_A, playerNotLeft);

            Action playerNotRight = new Action(new GameEvent<>(playerClass, playerClass.getMethod("removeToMovingOrders", Velocity.Direction.class), Velocity.Direction.RIGHT));
            actionReleaseMap.put(KeyEvent.VK_D, playerNotRight);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return actionReleaseMap;
    }

    static HashMap<Integer, Action> getAllMovePushActions(Class<? extends PhysicalObjectMoving> playerClass) {
        HashMap<Integer, Action> actionPushMap = new HashMap<>();

        actionPushMap.putAll(getAllArrowPushActions(playerClass));
        actionPushMap.putAll(getAllWASDPushActions(playerClass));

        return actionPushMap;
    }

    static HashMap<Integer, Action> getAllMoveReleaseActions(Class<? extends PhysicalObjectMoving> playerClass) {
        HashMap<Integer, Action> actionReleaseMap = new HashMap<>();

        actionReleaseMap.putAll(getAllArrowReleaseActions(playerClass));
        actionReleaseMap.putAll(getAllWASDReleaseActions(playerClass));

        return actionReleaseMap;
    }

    static HashMap<MouseHandler.MouseClick, Action> getAllMouseReleaseActions() {
        HashMap<MouseHandler.MouseClick, Action> mouseReleaseActionMap = new HashMap<>();

        try {
            GameEvent<ObjectHandler> leftClickEvent = new GameEvent<>(ObjectHandler.class, ObjectHandler.class.getMethod("doLeftMouseReleased", Position.class));
            ActionTimed leftClickAction = new ActionTimed(leftClickEvent, 200);

            mouseReleaseActionMap.put(MouseHandler.MouseClick.Left, leftClickAction);

            GameEvent<ObjectHandler> rightClickEvent = new GameEvent<>(ObjectHandler.class, ObjectHandler.class.getMethod("doRightMouseReleased", Position.class));
            ActionTimed rightClickAction = new ActionTimed(rightClickEvent, 200);

            mouseReleaseActionMap.put(MouseHandler.MouseClick.Right, rightClickAction);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return mouseReleaseActionMap;
    }

    static HashMap<MouseHandler.MouseClick, Action> getAllMousePressedActions() {
        HashMap<MouseHandler.MouseClick, Action> mousePressedActionMap = new HashMap<>();

        try {
            GameEvent<ObjectHandler> leftClickEvent = new GameEvent<>(ObjectHandler.class, ObjectHandler.class.getMethod("doLeftMousePressed", Position.class));
            ActionTimed leftClickAction = new ActionTimed(leftClickEvent, 200);

            mousePressedActionMap.put(MouseHandler.MouseClick.Left, leftClickAction);

            GameEvent<ObjectHandler> rightClickEvent = new GameEvent<>(ObjectHandler.class, ObjectHandler.class.getMethod("doRightMousePressed", Position.class));
            ActionTimed rightClickAction = new ActionTimed(rightClickEvent, 200);

            mousePressedActionMap.put(MouseHandler.MouseClick.Right, rightClickAction);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return mousePressedActionMap;
    }

}