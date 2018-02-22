package images;

import grid.GridSize;

import java.awt.image.BufferedImage;

/**
 * An assemble of images that changes every frame
 *
 * @author Jérémie Beaudoin-Dion
 */
class ImageSprite {

    private BufferedImage image;
    private int spriteCycle;
    private int currentSprite;
    private GridSize gridSize;

    ImageSprite(BufferedImage image, int spriteCycle, GridSize gridSize) {
        this.image = image;
        this.spriteCycle = spriteCycle;
        this.gridSize = gridSize;
    }

    BufferedImage getImage() {

        int size = gridSize.getValue();
        int x = currentSprite * size;
        int y = 0;

        updateSpriteValue();

        return image.getSubimage(x, y, size, size);
    }

    private void updateSpriteValue() {
        currentSprite++;
        currentSprite %= spriteCycle;
    }
}
