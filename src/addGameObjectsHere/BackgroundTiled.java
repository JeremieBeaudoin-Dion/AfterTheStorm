package addGameObjectsHere;

import addResourceLoaderHere.GameInformation;
import images.ImageLoader;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.display.Displayable;
import jGameFramework.display.DisplayableImage;
import jGameFramework.physicalObjects.BoundingArea;
import jGameFramework.physicalObjects.PhysicalObject;
import jGameFramework.physicalObjects.Position;

import java.util.List;
import java.util.TreeSet;

/**
 * @author Jérémie Beaudoin-Dion
 */
public class BackgroundTiled extends PhysicalObject {

    private int tileId;

    /**
     * Constructor
     */
    public BackgroundTiled(Position positionOnGrid, boolean isObstacle, int tileId) {
        super(getBoundingAreaForConstructor(positionOnGrid), isObstacle);

        this.tileId = tileId;
    }

    private static BoundingArea getBoundingAreaForConstructor(Position positionOnGrid) {

        int size = GameInformation.GRID_SIZE.getValue();
        int x = positionOnGrid.getX() * size;
        int y = positionOnGrid.getX() * size;

        return new BoundingArea(x, y, size, size);
    }

    /**
     * Returns the image representation of this physical object
     * <p>
     * The ImageObject will have a relative position depending
     * on the position of the CameraWithEdges.
     *
     * @param cameraPosition
     * @param imageLoader
     */
    @Override
    public TreeSet<Displayable> getImageObjects(Position cameraPosition, ImageLoader imageLoader) {
        TreeSet<Displayable> imagesToShowOnScreen = new TreeSet<>();

        imagesToShowOnScreen.add(new DisplayableImage(getPositionAccordingToCamera(cameraPosition), 0, imageLoader.getTile(tileId)));

        return imagesToShowOnScreen;
    }

    @Override
    public List<GameEvent> getAction() {
        return null;
    }

    @Override
    public boolean dispose() {
        return false;
    }

}
