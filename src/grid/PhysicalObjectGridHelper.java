package grid;

import jGameFramework.physicalObjects.Position;

/**
 * A helper for movement on the grid
 *
 * @author Jérémie Beaudoin-Dion
 */
class PhysicalObjectGridHelper {

    private GridSize gridSize;

    PhysicalObjectGridHelper(GridSize gridSize) {
        this.gridSize = gridSize;
    }

    boolean isFinishedMoving(Position currentPosition) {
        return currentPosition.getX() % gridSize.getValue() == 0 && currentPosition.getY() % gridSize.getValue() == 0;
    }

}
