package jGameFramework.core;

import jGameFramework.display.*;
import jGameFramework.physicalObjects.Position;

import java.awt.*;
import java.awt.Dimension;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.TreeSet;

import javax.swing.*;

/**
 * This class creates a JFrame instance.
 *
 * It draws the graphics on the frame and handles
 * double buffering.
 *
 * @author Jérémie Beaudoin-Dion
 *
 */
public class ImageHandler extends JFrame {

    // Assuming the INSETS will not change during the game
    static Insets INSETS;

    static Position POSITION_ON_SCREEN = new Position(0, 0);

    // Enables double buffer
    private BufferedImage backBuffer;

    /**
     * Constructor; creates the window and such
     */
    ImageHandler (){

        // Sets the parameter for the window
        setTitle(Game.GAME_NAME);
        setPreferredSize(new Dimension(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT));
        setResizable(Game.RESIZABLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        pack();

        // Makes sure the graphics don't get drawn on the border of the window
        INSETS = getInsets();
        setSize(INSETS.left + Game.WINDOW_WIDTH + INSETS.right,
                INSETS.top + Game.WINDOW_HEIGHT + INSETS.bottom);

        // Enables double buffer
        backBuffer = new BufferedImage(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, BufferedImage.TYPE_INT_RGB);

    }

    /**
     * Called every frame, this method handles graphics
     */
    void update(TreeSet<Displayable> displayableTreeSet) {

        updateLocationOnScreen();

        // Sets the double buffer
        Graphics2D g = (Graphics2D) getGraphics();
        Graphics2D bbg = (Graphics2D) backBuffer.getGraphics();

        // Sets the quality of the image to high
        setRenderingQuality(bbg);

        // Sets default background
        bbg.setColor(Color.BLACK);
        bbg.fillRect(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);

        // Draws the physical objects on the frame
        drawFrame(bbg, displayableTreeSet);

        // Draws the whole thing in one shot -- Double buffer
        g.drawImage(backBuffer, INSETS.left, INSETS.top, null);

        // Clears the cache
        bbg.dispose();
        g.dispose();

    }

    private void updateLocationOnScreen(){
        POSITION_ON_SCREEN = new Position(getLocationOnScreen().getX(), getLocationOnScreen().getY());
    }

    /**
     * Sets the desired rendering quality of the image
     */
    private void setRenderingQuality(Graphics2D bbg) {
        bbg.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        bbg.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        bbg.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (Game.ANTIALIASING) {
            bbg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        } else {
            bbg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }
    }

    /**
     * Displays all Displayables on screen
     */
    private void drawFrame(Graphics2D bbg, TreeSet<Displayable> displayableTreeSet) {

        for(Displayable object : displayableTreeSet) {
            printDisplayableOnBuffer(bbg, object);
        }

    }

    /**
     * Sends the displayable to the correct method in order to be put on screen
     */
    private void printDisplayableOnBuffer(Graphics2D bbg, Displayable displayable) {
        if (displayable instanceof DisplayableImage) {
            printImage(bbg, (DisplayableImage) displayable);

        } else if (displayable instanceof DisplayableShapeOutline) {
            printShapeOutline(bbg, (DisplayableShapeOutline) displayable);

        } else if (displayable instanceof DisplayableShapeFilled){
            printShapeFilled(bbg, (DisplayableShapeFilled) displayable);

        } else if (displayable instanceof DisplayableText){
            printText(bbg, (DisplayableText) displayable);
        }
    }

    private void printImage(Graphics2D bbg, DisplayableImage displayableImage) {
        bbg.drawImage(displayableImage.getImage(), displayableImage.getPosition().getX(),
                displayableImage.getPosition().getY(), null);
    }

    private void printShapeOutline(Graphics2D bbg, DisplayableShapeOutline displayableShapeOutline) {
        bbg.setPaint(displayableShapeOutline.getPaint());
        bbg.setStroke(displayableShapeOutline.getStroke());

        bbg.draw(displayableShapeOutline.getShape());
    }

    private void printShapeFilled(Graphics2D bbg, DisplayableShapeFilled displayableShapeFilled) {
        bbg.setPaint(displayableShapeFilled.getPaint());

        bbg.fill(displayableShapeFilled.getShape());
    }

    private void printText(Graphics2D bbg, DisplayableText displayableText) {
        bbg.setPaint(displayableText.getPaint());
        bbg.setFont(displayableText.getFont());

        bbg.drawString(displayableText.getMessage(), displayableText.getPosition().getX(),
                displayableText.getPosition().getY());
    }

    @Override
    public void paint (Graphics g) {}

    @Override
    public void repaint () {}

    public void resizeIfNotNull(Position nextScreenSize) {
        if (nextScreenSize != null) {
            super.setSize(nextScreenSize.getX(), nextScreenSize.getY());
        }

    }

}

