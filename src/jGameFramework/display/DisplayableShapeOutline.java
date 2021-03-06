package jGameFramework.display;

import jGameFramework.physicalObjects.BoundingArea;

import java.awt.*;

/**
 * A shape that can be put on screen. Only its outline will be
 * seen. To show a FilledShape, use DisplayableShapeFilled.
 *
 * The default stroke value is a solid outline.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class DisplayableShapeOutline extends DisplayableShape {

    private Stroke stroke;

    /**
     * Constructors for a solid BLACK outline
     */
    public DisplayableShapeOutline(int depth, Shape shape) {
        super(new DisplayableDepth(depth), shape, Color.BLACK);
        this.stroke = new BasicStroke();
    }

    /**
     * Constructors for a solid outline
     */
    public DisplayableShapeOutline(int depth, Shape shape, Paint paint) {
        super(new DisplayableDepth(depth), shape, paint);
        this.stroke = new BasicStroke();
    }

    public DisplayableShapeOutline(int depth, BoundingArea area, Paint paint) {
        super(new DisplayableDepth(depth), area.getArea(), paint);
        this.stroke = new BasicStroke();
    }

    /**
     * Constructor for a specific desired outline
     */
    public DisplayableShapeOutline(int depth, Shape shape, Paint paint, Stroke stroke){
        super(new DisplayableDepth(depth), shape, paint);
        this.stroke = stroke;
    }

    public Stroke getStroke(){
        return stroke;
    }

}
