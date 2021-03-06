package grid;

import jGameFramework.physicalObjects.*;

import java.util.TreeSet;


/**
 * A physical object that moves on a grid
 *
 * // TODO: When the movement is held, there is a bit of stutter... Maybe add a queue?
 *
 * @author Jérémie Beaudoin-Dion
 */
public abstract class PhysicalObjectMovingOnGrid extends PhysicalObjectMoving {

    private boolean isMoving;
    private Velocity.Direction currentDirection;

    private PhysicalObjectGridHelper gridHelper;

    /**
     * Constructor
     */
    public PhysicalObjectMovingOnGrid(BoundingArea area, Vision vision, GridSize gridSize, int speed) {
        super(area, true, vision, new VelocitySquare(speed, speed));

        gridHelper = new PhysicalObjectGridHelper(gridSize);

        isMoving = false;
        currentDirection = null;
    }

    /**
     * Called every frame
     */
    @Override
    protected void updateAndMove(TreeSet<PhysicalObject> surroundings){
        super.updateAndMove(surroundings);

        updateGridMovement();
    }

    private void updateGridMovement() {
        if (isMoving) {
            if (gridHelper.isFinishedMoving(getPosition())) {
                isMoving = false;
                currentDirection = null;
                super.removeAllMovingOrders();
            } else {
                super.addToMovingOrders(currentDirection);
            }
        }
    }

    /**
     * Can only move one direction at a time
     */
    @Override
    public void addToMovingOrders(Velocity.Direction direction) {
        if (!isMoving || gridHelper.isFinishedMoving(getPosition())) {
            currentDirection = direction;
            isMoving = true;
            super.addToMovingOrders(currentDirection);
        }
    }

    /**
     * The moving order will be removed automatically once the object snaps with
     * the grid.
     */
    @Override
    public void removeToMovingOrders(Velocity.Direction direction) {
        // Do nothing
    }

}
