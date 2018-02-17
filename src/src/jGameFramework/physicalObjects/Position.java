package jGameFramework.physicalObjects;

import java.awt.*;
import java.io.Serializable;

/**
 * A Position is an object which has two variables representing
 * the X axis and the Y axis as Integers.
 *
 * The creation of such a simple class is most of the time not
 * a good idea. That said, I felt it was necessary to create my
 * Point() class in order to store the variables as integers and
 * the compareTo() method.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Position implements Comparable<Position>, Cloneable, Serializable {

    private int x;
    private int y;

    /**
     * The constructor
     *
     * @param x: the X axis integer
     * @param y: the Y axis integer
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(double x, double y) {
        this.x = (int) Math.round(x);
        this.y = (int) Math.round(y);
    }

    public Position(Dimension dimension) {
        this.x = dimension.width;
        this.y = dimension.height;
    }

    /**
     * Returns a new position with the added values
     * of the current and the other
     */
    public Position add(Position other) {
        return new Position(x + other.getX(), y + other.getY());
    }

    /**
     * Returns the opposite of this position ; the x and y arguments are negative if they are
     * positive and positive if they are negative
     */
    public Position reverse() {
        return new Position(-x, -y);
    }

    /**
     * Using Pythagorean equation to find the true distance between two Positions
     */
    public double getDistance(Position other) {
        return Math.sqrt(Math.pow(x - other.getX(), 2.0) + Math.pow(x - other.getX(), 2.0));
    }

    /**
     * Compares two positions
     *
     * The most important value is the y axis. If those are the same,
     * then the x axis is compared.
     */
    @Override
    public int compareTo(Position position) {
        if (y == position.getY()) {
            return x - position.getX();
        }

        return y - position.getY();
    }

    @Override
    public Position clone() {
        return new Position(x, y);
    }

    @Override
    public boolean equals(Object other){
        if (other instanceof Position){
            return getX() == ((Position) other).getX() && getY() == ((Position) other).getY();
        }

        return false;
    }

    @Override
    public String toString(){
        return "(x=" + x + ", y=" + y + ")";
    }

    /**
     * Getters
     */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}