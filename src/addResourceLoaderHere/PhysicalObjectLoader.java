package addResourceLoaderHere;

import addGameObjectsHere.camera.CameraStill;
import addGameObjectsHere.player.Player;
import images.ImageLoader;
import jGameFramework.core.Loader;
import jGameFramework.physicalObjects.Camera;
import jGameFramework.physicalObjects.PhysicalObject;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Loads all game objects to create GameThreads.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class PhysicalObjectLoader implements Loader<TreeSet<PhysicalObject>> {

    private Player player;
    private ImageLoader imageLoader;

    public PhysicalObjectLoader(ImageLoader imageLoader){
        this.imageLoader = imageLoader;
        player = new Player();
    }

    public TreeSet<PhysicalObject> get(GameThreadID gameThreadID){
        switch (gameThreadID){
            case MainMenu:
                return null;

            case Game:
                return getGameObjects();
        }

        throw new IllegalArgumentException("The GameThreadID: " + gameThreadID + " is not implemented.");
    }

    private TreeSet<PhysicalObject> getGameObjects() {
        TreeSet<PhysicalObject> objects = new TreeSet<>();

        objects.add(getPlayerObject());

        objects.addAll(getTestObjs());

        return objects;
    }

    private List<PhysicalObject> getTestObjs() {

        List<PhysicalObject> testList = new LinkedList<>();

        // TODO

        return testList;
    }

    public Camera getCamera(GameThreadID gameThreadID){
        return new CameraStill();
    }

    /**
     * Player object
     */
    private Player getPlayerObject(){
        return player;
    }

}
