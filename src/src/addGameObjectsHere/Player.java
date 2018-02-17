package addGameObjectsHere;

import addResourceLoaderHere.ImageLoader;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.coreActions.GameThreadEventQuit;
import jGameFramework.display.Displayable;
import jGameFramework.display.DisplayableDepth;
import jGameFramework.display.DisplayableShapeFilled;
import jGameFramework.display.DisplayableText;
import jGameFramework.physicalObjects.Position;
import jGameFramework.physicalObjects.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 * An jGameFramework.example of a simple Player object.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Player extends PhysicalObjectMoving {

    /**
     * Constructor
     */
    public Player() {
        super(new BoundingArea(new Rectangle2D.Float()), true,
                new VisionRectangle(200, 200), new VelocitySquare(2, 2));

    }

    @Override
    public TreeSet<PhysicalObject> update(TreeSet<PhysicalObject> surroundings) {
        updateAndMove(surroundings);

        return null;
    }

    @Override
    public TreeSet<Displayable> getImageObjects(Position cameraPosition, ImageLoader imageLoader) {
        TreeSet<Displayable> imagesToShowOnScreen = new TreeSet<>();

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
