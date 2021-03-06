package images;

import grid.GridSize;

import java.awt.image.BufferedImage;

/**
 * An assemble of images that changes every frame.
 *
 * The the images will cycle through only x values.
 *
 * @author Jérémie Beaudoin-Dion
 */
class ImageSpriteAnimated extends ImageSprite {

    private int spriteCycle;
    private int currentSprite;

    ImageSpriteAnimated(BufferedImage image, GridSize gridSize, int numberOfImagesPerRow) {
        super(image, gridSize, numberOfImagesPerRow);

        currentSprite = 0;
        spriteCycle = numberOfImagesPerRow;
    }

    public BufferedImage getSubImage() {
        updateSpriteValue();

        return super.getSubImage(currentSprite);
    }

    private void updateSpriteValue() {
        currentSprite++;
        currentSprite %= spriteCycle;
    }
}
