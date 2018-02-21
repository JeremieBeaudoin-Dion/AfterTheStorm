package grid;

import jGameFramework.physicalObjects.Position;

/**
 * A helper for movement on the grid
 *
 * @author Jérémie Beaudoin-Dion
 */
class PhysicalObjectGridHelper {

    private int gridSize;

    PhysicalObjectGridHelper(int gridSize) {
        this.gridSize = gridSize;
    }

    boolean isFinishedMoving(Position currentPosition) {
        return currentPosition.getX() % gridSize == 0 && currentPosition.getY() % gridSize == 0;
    }

}
