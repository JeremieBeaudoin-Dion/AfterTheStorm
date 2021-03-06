package addGameObjectsHere.player;

import addResourceLoaderHere.GameInformation;
import images.ImageLoader;
import grid.PhysicalObjectMovingOnGrid;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.display.Displayable;
import jGameFramework.display.DisplayableImage;
import jGameFramework.display.DisplayableShapeFilled;
import jGameFramework.physicalObjects.Position;
import jGameFramework.physicalObjects.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.TreeSet;

/**
 * An jGameFramework.example of a simple Player object.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Player extends PhysicalObjectMovingOnGrid {

    /**
     * Constructor
     */
    public Player() {
        super(new BoundingArea(new Rectangle2D.Float(0, 0, GameInformation.GRID_SIZE.getValue(), GameInformation.GRID_SIZE.getValue())),
                new VisionRectangle(150, 150), GameInformation.GRID_SIZE, 2);

    }

    @Override
    public TreeSet<PhysicalObject> update(TreeSet<PhysicalObject> surroundings) {
        updateAndMove(surroundings);

        return null;
    }

    @Override
    public TreeSet<Displayable> getImageObjects(Position cameraPosition, ImageLoader imageLoader) {
        TreeSet<Displayable> imagesToShowOnScreen = new TreeSet<>();

        imagesToShowOnScreen.add(new DisplayableImage(getPositionAccordingToCamera(cameraPosition), 100, imageLoader.getPlayerImage()));

        return imagesToShowOnScreen;
    }

    @Override
    public List<GameEvent> getAction() {
        return null;
    }

    /**
     * If the player would be disposed, the current
     * GameThread will be quit.
     */
    @Override
    public boolean dispose() {
        return false;
    }


}
