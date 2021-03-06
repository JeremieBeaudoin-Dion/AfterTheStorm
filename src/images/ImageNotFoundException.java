package images;

/**
 * An exception thrown when the images are missing
 *
 * @author Jérémie Beaudoin-Dion
 */
public class ImageNotFoundException extends RuntimeException {

    ImageNotFoundException(String imagePath) {
        System.err.println("Fatal error, could not load image: " + imagePath);
    }

}
