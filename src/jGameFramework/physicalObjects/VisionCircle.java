package jGameFramework.physicalObjects;

import java.awt.geom.Ellipse2D;
import java.io.Serializable;

/**
 * A round vision that uses a single variable as radius.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class VisionCircle implements Vision, Serializable {

    private int diameter;

    public VisionCircle(int diameter) {
        this.diameter = diameter;
    }

    /**
     * Returns true if the baseObject can see the other according
     * to this vision's dimensions
     */
    public boolean isInSight(Position centerOfOwner, PhysicalObject other) {
        BoundingArea area = getEllipseAreaFromCenterPosition(centerOfOwner, diameter, diameter);

        return area.collidesWith(other.getBoundingArea());
    }

    /**
     * Creates a new RectangleBoundingArea according to a position which
     * represent the center of the Area and a width and height
     */
    private static BoundingArea getEllipseAreaFromCenterPosition(Position centerPosition, int width, int height){
        Position actualPosition = centerPosition.add(new Position(-width/2, -height/2));

        return new BoundingArea(new Ellipse2D.Float(actualPosition.getX(), actualPosition.getY(), width, height));
    }

}
