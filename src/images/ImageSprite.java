package images;

import grid.GridSize;
import jGameFramework.physicalObjects.Position;

import java.awt.image.BufferedImage;

/**
 * A type of image that holds many other images
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ImageSprite {

    private final BufferedImage image;
    private final GridSize gridSize;
    private int numberOfImagesPerRow;

    ImageSprite(BufferedImage image, GridSize gridSize, int numberOfImagesPerRow) {
        this.image = image;
        this.gridSize = gridSize;
        this.numberOfImagesPerRow = numberOfImagesPerRow;
    }

    public BufferedImage getSubImage(int number) {
        Position gridPosition = getXAndYAccordingToID(number);

        int size = gridSize.getValue();

        int x = gridPosition.getX() * size;
        int y = gridPosition.getX() * size;

        return image.getSubimage(x, y, size, size);
    }

    /**
     * Returns the position of an ID'ed image. Starting at 0.
     */
    private Position getXAndYAccordingToID(int number) {
        int y = number / numberOfImagesPerRow;
        int x = number % numberOfImagesPerRow;

        return new Position(x, y);
    }

    ////////////////////////////////////////////////////////////////////////
    // TEST
    ////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {

        System.out.println("Testing getXAndYAccordingToID: " + testGetXAndYAccordingToID());

    }

    private static boolean testGetXAndYAccordingToID() {
        boolean test15 = test15SpriteID();
        boolean test2X = test2XSpriteID();
        boolean test2Y = test2YSpriteID();

        System.out.println("     subtest 15 sprites: " + test15);
        System.out.println("     subtest 15 sprites: " + test2X);
        System.out.println("     subtest 15 sprites: " + test2Y);

        return test2X && test2Y && test15;
    }

    private static boolean test15SpriteID() {
        ImageSprite img = new ImageSprite(null, GridSize.Small, 5);

        Position p0 = img.getXAndYAccordingToID(0);
        Position expectedP0 = new Position(0, 0);

        Position p4 = img.getXAndYAccordingToID(4);
        Position expectedP4 = new Position(4, 0);

        Position p13 =img.getXAndYAccordingToID(13);
        Position expectedP13 = new Position(3, 2);

        return p4.equals(expectedP4) && p13.equals(expectedP13);
    }

    private static boolean test2XSpriteID() {
        ImageSprite img = new ImageSprite(null, GridSize.Small, 2);

        Position p2 = img.getXAndYAccordingToID(1);
        Position expectedP2 = new Position(1, 0);

        return p2.equals(expectedP2);
    }

    private static boolean test2YSpriteID() {
        ImageSprite img = new ImageSprite(null, GridSize.Small, 1);

        Position p2 = img.getXAndYAccordingToID(1);
        Position expectedP2 = new Position(0, 1);

        return p2.equals(expectedP2);
    }

}



