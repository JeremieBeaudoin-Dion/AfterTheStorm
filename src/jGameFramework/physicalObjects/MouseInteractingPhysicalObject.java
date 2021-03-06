package jGameFramework.physicalObjects;

/**
 * Any object that implements this interface can interact
 * with the mouse (click, pressed, released).
 *
 * @author Jérémie Beaudoin-Dion
 */
public interface MouseInteractingPhysicalObject {

    void doLeftMousePressed(Position mousePositionCollidingWithObject);

    void doLeftMouseReleased(Position mousePositionCollidingWithObject);

    void doRightMousePressed(Position mousePositionCollidingWithObject);

    void doRightMouseReleased(Position mousePositionCollidingWithObject);

}
