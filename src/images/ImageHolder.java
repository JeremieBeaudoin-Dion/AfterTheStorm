package images;

import grid.GridSize;
import jGameFramework.core.LoaderOfImages;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A type of holder that returns the desired images
 *
 * @author Jérémie Beaudoin-Dion
 */
class ImageHolder extends LoaderOfImages {

    private GridSize gridSize;

    private ImageSpriteAnimated playerSprite;
    private ImageSprite tilesetSprite;

    ImageHolder(GridSize gridSize) {
        this.gridSize = gridSize;

        try {
            loadAllImages();

        } catch (IOException e) {
            throw new ImageNotFoundException(e.getMessage());  // TODO: get path
        }

    }

    private void loadAllImages() throws IOException {
        BufferedImage playerImage = toCompatibleImage(ImageIO.read(new File("resources/images/"+ gridSize.getValue() +"/robot"+ gridSize.getValue() +".png")));
        playerSprite = new ImageSpriteAnimated(playerImage, gridSize, 1);  // todo, change back to 3

        BufferedImage tilesetImage = toCompatibleImage(ImageIO.read(new File("resources/images/"+ gridSize.getValue() +"/TileRobot"+ gridSize.getValue() +".png")));
        tilesetSprite = new ImageSpriteAnimated(tilesetImage, gridSize, 1);

    }

    BufferedImage getPlayer() {
        return playerSprite.getSubImage();
    }

    BufferedImage getTile(int tileNumber) {
        return tilesetSprite.getSubImage(tileNumber);
    }

}
