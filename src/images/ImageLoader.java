package images;

import addResourceLoaderHere.GameInformation;
import grid.GridSize;
import jGameFramework.core.LoaderOfImages;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Loads images in order to be displayed on screen
 *
 * This class is necessary for the JGame Framework to work.
 * It can load as many images as needed.
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ImageLoader extends LoaderOfImages {

    private Map<GridSize, ImageHolder> imageHolderMap;

    /**
     * Basic constructor
     * @throws IOException if an image is missing
     */
    public ImageLoader() throws IOException {

        imageHolderMap = new HashMap<>();

        for (GridSize gridSize: GridSize.values()) {
            imageHolderMap.put(gridSize, new ImageHolder(gridSize));
        }

    }

    public BufferedImage getPlayerImage() {
        return imageHolderMap.get(GameInformation.GRID_SIZE).getPlayer();
    }

    public BufferedImage getTile(int tileID) {
        return imageHolderMap.get(GameInformation.GRID_SIZE).getTile(tileID);
    }

}
