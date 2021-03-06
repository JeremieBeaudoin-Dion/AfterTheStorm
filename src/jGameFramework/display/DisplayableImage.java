package jGameFramework.display;

import jGameFramework.physicalObjects.Position;

import java.awt.*;

/**
 * Displays the desired image on screen
 *
 * @author Jérémie Beaudoin-Dion
 */
public class DisplayableImage extends Displayable {

    private Image image;

    /**
     * Constructors
     */
    public DisplayableImage(Position position, int depth, Image image) {
        super(position, new DisplayableDepth(depth));
        this.image = image;
    }

    public Image getImage(){
        return image;
    }

}
