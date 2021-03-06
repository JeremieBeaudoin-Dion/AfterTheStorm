package jGameFramework.exceptions;

/**
 * @author Jérémie Beaudoin-Dion
 */
public class EmptyThreadException extends RuntimeException {

    public EmptyThreadException(){
        super("The threads are empty, stopping game...");
    }

}
