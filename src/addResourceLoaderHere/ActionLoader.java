package addResourceLoaderHere;

import addGameObjectsHere.player.Player;
import jGameFramework.collections.InputActionKeyMap;
import jGameFramework.core.Loader;

/**
 * An instance of Loader that returns InputActionKeyMap,
 * a Map necessary to interpret input from the user.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ActionLoader implements Loader<InputActionKeyMap> {

    public InputActionKeyMap get(GameThreadID gameThreadID){

        return new InputActionKeyMap(ActionMapHelper.getAllMovePushActions(Player.class),
                ActionMapHelper.getAllMoveReleaseActions(Player.class),
                ActionMapHelper.getAllMousePressedActions(),
                ActionMapHelper.getAllMouseReleaseActions());
    }

}

