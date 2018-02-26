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

    private ImageSprite playerSprite;

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
        playerSprite = new ImageSprite(playerImage, 1, gridSize);  // todo, change back to 3

    }

    BufferedImage getPlayer() {
        return playerSprite.getImage();
    }

}
