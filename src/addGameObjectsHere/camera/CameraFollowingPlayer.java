package addGameObjectsHere.camera;

import addGameObjectsHere.player.Player;
import images.ImageLoader;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.display.Displayable;
import jGameFramework.physicalObjects.Position;
import jGameFramework.physicalObjects.Camera;
import jGameFramework.physicalObjects.PhysicalObject;

import java.util.List;
import java.util.TreeSet;

/**
 * @author Jérémie Beaudoin-Dion
 */
public class CameraFollowingPlayer extends Camera {

    private Player playerReference;

    public CameraFollowingPlayer(Player player){
        super();

        playerReference = player;

        setPlayerInCenterOfScreen();
    }

    /**
     * When updated, makes sure the player is at the center of the screen
     */
    @Override
    public TreeSet<PhysicalObject> update(TreeSet<PhysicalObject> surroundings) {
        setPlayerInCenterOfScreen();

        return null;
    }

    private void setPlayerInCenterOfScreen(){
        Position centerOfCamera = getBoundingArea().getCenterPosition();
        Position playerPosition = playerReference.getBoundingArea().getCenterPosition();

        Position differenceBetweenCenters = playerPosition.add(new Position(-centerOfCamera.getX(), -centerOfCamera.getY()));

        Position actualCameraPosition = getPosition();
        Position newCameraPosition = actualCameraPosition.add(differenceBetweenCenters);

        setPositionTo(newCameraPosition);
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
