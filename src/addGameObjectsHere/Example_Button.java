package addGameObjectsHere;

import addResourceLoaderHere.GameThreadID;
import images.ImageLoader;
import jGameFramework.core.Game;
import jGameFramework.coreActions.GameEvent;
import jGameFramework.coreActions.GameThreadEventNew;
import jGameFramework.coreActions.GameThreadEventResize;
import jGameFramework.display.Displayable;
import jGameFramework.display.DisplayableDepth;
import jGameFramework.display.DisplayableShapeFilled;
import jGameFramework.display.DisplayableText;
import jGameFramework.physicalObjects.*;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * An jGameFramework.example of a button which, on click, will return an action
 * that will set the game to a new thread (GAME_LEVEL_1 in this case).
 *
 * This jGameFramework.example is pretty simple and could have been set as a child
 * of a parent Button, but it should be a good jGameFramework.example of the use
 * of the Framework.
 *
 * The action is set to null every frame, to ensure that it is
 * done only once.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class Example_Button extends PhysicalObject implements MouseInteractingPhysicalObject {

    private static final Font FONT_BUTTON = new Font("Century Schoolbook", Font.PLAIN, 25);

    private static final int width = 300;
    private static final int height = 50;

    private GameEvent actionToDo;

    /**
     * Constructor
     *
     * In this jGameFramework.example, no argument is passed as Position, which is simpler
     * but less viable. A position could be passed to make the Button more
     * generic.
     */
    public Example_Button() {
        super(BoundingArea.getRectangleAreaFromCenterPosition(new Position(Game.WINDOW_HEIGHT/2, Game.WINDOW_WIDTH/2),
                width, height), false);

        actionToDo = null;
    }

    /**
     * Returns a square with the text "PLAY!" printed on it.
     *
     * In this jGameFramework.example, the jGameFramework.display of this button is INDEPENDENT
     * of the position of the camera.
     */
    @Override
    public TreeSet<Displayable> getImageObjects(Position cameraPosition, ImageLoader imageLoader) {
        TreeSet<Displayable> imagesToShowOnScreen = new TreeSet<>();

        RoundRectangle2D rect = new RoundRectangle2D.Double(getPosition().getX(), getPosition().getY(),
                getWidth(), getHeight(), 5, 5);

        GradientPaint paint = new GradientPaint(getPosition().getX(), getPosition().getY(), Color.DARK_GRAY,
                getBoundingArea().getCenterPosition().getX(), getBoundingArea().getCenterPosition().getY(), Color.BLACK);

        imagesToShowOnScreen.add(new DisplayableShapeFilled(DisplayableDepth.MIDDLE, rect, paint));

        Position positionOfText = getPosition().add(new Position(getWidth()/3,getHeight()/2));

        imagesToShowOnScreen.add(new DisplayableText(positionOfText, DisplayableDepth.HIGHEST, "PLAY!",
                FONT_BUTTON, Color.GREEN));

        return imagesToShowOnScreen;
    }

    @Override
    public void doLeftMouseReleased(Position mousePositionCollidingWithObject) {
        actionToDo = new GameThreadEventNew(GameThreadID.Game);
    }

    @Override
    public void doLeftMousePressed(Position mousePositionCollidingWithObject) {

    }

    @Override
    public void doRightMouseReleased(Position mousePositionCollidingWithObject){
        actionToDo = new GameThreadEventResize(new Position(500, 700));
    }

    @Override
    public void doRightMousePressed(Position mousePositionCollidingWithObject){

    }

    /**
     * Returns a list of actions to do. In this case, it will only
     * have one element if any.
     *
     * Ensures that the action is set back to null after it is called
     */
    @Override
    public List<GameEvent> getAction() {
        List<GameEvent> actionsToDo = new LinkedList<>();

        if (actionToDo != null) {
            actionsToDo.add(actionToDo);
            actionToDo = null;
        }

        return actionsToDo;
    }

    @Override
    public boolean dispose() {
        return false;
    }

}
