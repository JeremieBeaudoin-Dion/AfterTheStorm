package jGameFramework.physicalObjects;

import images.ImageLoader;
import jGameFramework.core.ObjectWithID;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.display.Displayable;

import java.awt.geom.Area;
import java.io.Serializable;
import java.util.List;
import java.util.TreeSet;

/**
 * A physical object has a Displayable representation of itself
 * that can be put on screen.
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class PhysicalObject extends ObjectWithID implements Serializable {

    private BoundingArea boundingArea;

    private boolean obstacle;

    /**
     * Constructor
     */
    public PhysicalObject(BoundingArea boundingArea, boolean isObstacle) {
        this.boundingArea = boundingArea;
        this.obstacle = isObstacle;
    }

    /**
     * Returns the image representation of this physical object
     *
     * The ImageObject will have a relative position depending
     * on the position of the CameraWithEdges.
     */
    public abstract TreeSet<Displayable> getImageObjects(Position cameraPosition, ImageLoader imageLoader);

    public abstract List<GameEvent> getAction();

    public abstract boolean dispose();

    public void resize(Position lastScreenSize, Position newScreenSize) {
        double widthMultiplier = newScreenSize.getX() / (double) lastScreenSize.getX();
        double heightMultiplier = newScreenSize.getY() / (double) lastScreenSize.getY();

        resizeWidthAndHeight(widthMultiplier, heightMultiplier);
        resizePosition(widthMultiplier, heightMultiplier);
    }

    protected void resizeWidthAndHeight(double widthMultiplier, double heightMultiplier) {
        setWidthAndHeight(widthMultiplier * getWidth(), heightMultiplier * getHeight());
    }

    protected void resizePosition(double xMultiplier, double yMultiplier) {
        Position newPosition = new Position(getPosition().getX() * xMultiplier, getPosition().getY() * yMultiplier);

        setPositionTo(newPosition);
    }

    /**
     * PhysicalObjects are compared according to their position on the screen.
     *
     * If those are equals, they are compared in order of appearance in the game.
     */
    @Override
    public int compareTo(ObjectWithID objectWithID) {
        if (!(objectWithID instanceof PhysicalObject)){
            return super.compareTo(objectWithID);
        }

        PhysicalObject other = (PhysicalObject) objectWithID;

        if (boundingArea.getPosition().compareTo(other.getPosition()) == 0){
            return super.compareTo(objectWithID);
        }

        return boundingArea.getPosition().compareTo(other.getPosition());
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof PhysicalObject && compareTo((PhysicalObject) other) == 0;
    }

    /**
     * Places the PhysicalObject at the desiredPosition
     */
    protected void setPositionTo(Position newPosition) {
        boundingArea.setPosition(newPosition);
    }

    public boolean isColliding(Position position) {
        return  boundingArea.collidesWith(position);
    }

    public boolean isColliding(PhysicalObject other) {
        return boundingArea.collidesWith(other.getBoundingArea());
    }

    boolean isColliding(BoundingArea areaOther){
        return boundingArea.collidesWith(areaOther);
    }

    /**
     * If an other object can pass through this one
     */
    boolean isObstacle(){
        return obstacle;
    }

    /**
     * Useful method to get the value of the current position according
     * to the camera's. It is mostly useful when creating the TreeSet of
     * the ImageObjects of this object.
     */
    protected Position getPositionAccordingToCamera(Position cameraPosition) {
        return boundingArea.getPosition().add(cameraPosition.reverse());
    }

    protected Area getAreaAccordingToCamera(Position cameraPosition) {
        BoundingArea copyArea = boundingArea.clone();

        copyArea.setPosition(copyArea.getPosition().add(cameraPosition.reverse()));

        return copyArea.getArea();
    }

    BoundingArea getObjectAreaAtPosition(Position position){
        BoundingArea objectAreaAtPosition = boundingArea.clone();
        objectAreaAtPosition.setPosition(position);

        return objectAreaAtPosition;
    }

    public BoundingArea getBoundingArea(){
        return boundingArea;
    }

    public Position getPosition(){
        return boundingArea.getPosition();
    }

    protected double getWidth(){
        return boundingArea.getWidth();
    }

    protected double getHeight(){
        return boundingArea.getHeight();
    }

    protected void setWidthAndHeight(double width, double height) {
        boundingArea.setWidthAndHeight(width, height);
    }

    @Override
    public String toString(){
        return "PhysicalObject number " + getId() + ": " + this.getClass() + " at Position: " + boundingArea.getPosition().toString();
    }

}
