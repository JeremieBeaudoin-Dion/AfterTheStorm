package addGameObjectsHere.camera;

import images.ImageLoader;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.display.Displayable;
import jGameFramework.physicalObjects.Position;
import jGameFramework.physicalObjects.Camera;
import jGameFramework.physicalObjects.PhysicalObject;

import java.util.List;
import java.util.TreeSet;

/**
 * A camera that does not move.
 *
 * Useful for the menus
 *
 * @author Jérémie Beaudoin-Dion
 */
public class CameraStill extends Camera{

    public CameraStill(){
        super();
    }

    @Override
    public TreeSet<PhysicalObject> update(TreeSet<PhysicalObject> surroundings) {
        // Do nothing
        return null;
    }

    @Override
    public TreeSet<Displayable> getImageObjects(Position cameraPosition, ImageLoader imageLoader) {
        return null;
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
