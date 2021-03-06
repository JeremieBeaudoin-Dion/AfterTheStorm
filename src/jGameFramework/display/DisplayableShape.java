package jGameFramework.display;

import jGameFramework.physicalObjects.Position;

import java.awt.*;

/**
 * A shape that can be displayed on screen. It has a colour
 * and a java.awt shape.
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class DisplayableShape extends Displayable {

    private Shape shape;
    private Paint paint;

    /**
     * Constructors
     */
    public DisplayableShape(DisplayableDepth depth, Shape shape, Paint paint) {
        super(new Position(shape.getBounds().x, shape.getBounds().y), depth);
        this.shape = shape;
        this.paint = paint;
    }

    public Shape getShape(){
        return shape;
    }

    public Paint getPaint(){
        return paint;
    }
}
