package jGameFramework.display;

import jGameFramework.physicalObjects.BoundingArea;

import java.awt.*;

/**
 * A displayable shape which will be filled with a desired color.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class DisplayableShapeFilled extends DisplayableShape {

    /**
     * Constructors
     */
    public DisplayableShapeFilled(int depth, Shape shape, Paint paint) {
        super(new DisplayableDepth(depth), shape, paint);
    }

    public DisplayableShapeFilled(int depth, BoundingArea area, Paint paint) {
        super(new DisplayableDepth(depth), area.getArea(), paint);
    }

}
