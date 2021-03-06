package jGameFramework.test;

/**
 * @author Jérémie Beaudoin-Dion
 */

import jGameFramework.display.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * A very lightweight JFrame to show the shapes
 */
public class TestFrame extends JFrame {

    private TreeSet<Displayable> displayableList;

    public TestFrame() {
        displayableList = new TreeSet<>();

        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        setVisible(true);
        pack();
    }

    public void update() {

        Graphics2D g = (Graphics2D) getGraphics();
        drawFrame(g);
    }

    /**
     * Displays all Displayables on screen
     */
    private void drawFrame(Graphics2D bbg) {

        for(Displayable object : displayableList) {
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


    /**
     * Adding objects to show
     */
    public void addDisplayable(Displayable displayable) {
        displayableList.add(displayable);
    }

}
