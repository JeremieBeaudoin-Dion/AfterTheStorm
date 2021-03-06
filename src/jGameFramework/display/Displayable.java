package jGameFramework.display;

import jGameFramework.core.ObjectWithID;
import jGameFramework.physicalObjects.Position;

/**
 * Displayables are objects which can be displayed on screen
 * using the ImageHandler.
 *
 * Their Depth represent the order in which the Displayables will be put,
 * to make sure a Foreground object is over a Background object.
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class Displayable extends ObjectWithID {

    private DisplayableDepth depth;
    private Position position;

    /**
     * Constructors
     */
    public Displayable(Position position, DisplayableDepth depth) {
        this.depth = depth;
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    /**
     * Displayables are foremost compared with their depth values.
     * A FLOATING image will be added to the frame after any FOREGROUND
     * jGameFramework.display, for jGameFramework.example.
     *
     * If the depth values are the same, the positions are compared
     */
    @Override
    public int compareTo(ObjectWithID objectWithID) {
        if (!(objectWithID instanceof Displayable)){
            return super.compareTo(objectWithID);
        }

        Displayable other = (Displayable) objectWithID;

        if (depth.equals(other.depth)) {
            if (position.equals(other.getPosition())){
                return super.compareTo(other);
            }

            return position.compareTo(other.getPosition());
        }

        return depth.compareTo(other.depth);
    }

}
