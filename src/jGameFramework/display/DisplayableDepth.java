package jGameFramework.display;

import jGameFramework.physicalObjects.BoundingArea;
import jGameFramework.test.TestFrame;

import java.awt.*;

import static java.lang.Thread.sleep;

/**
 * @author Jérémie Beaudoin-Dion
 */
public class DisplayableDepth implements Comparable<DisplayableDepth> {

    public static final int BACKGROUND = 0;
    public static final int MIDDLE = Integer.MAX_VALUE/2;
    public static final int HIGHEST = Integer.MAX_VALUE;

    private int value;

    /**
     * Creates a Depth. The bigger the value, the closer to
     * the screen the Displayable will be.
     *
     * The minimum value BACKGROUND is zero.
     *
     * @param value: integer bigger than zero
     */
    DisplayableDepth(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("The value must be bigger than zero. Value: " + value);
        }

        this.value = value;
    }

    @Override
    public int compareTo(DisplayableDepth other) {
        return this.value - other.value;
    }

    ///////////////////////////////////////////////
    // TEST
    //////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println("Comparable test: " + testCompare());

        System.out.println("Testing objects on top of each other...");
        testOnTopOfEachOther();
    }

    public static boolean testCompare() {
        DisplayableDepth smallest = new DisplayableDepth(BACKGROUND);

        DisplayableDepth middle = new DisplayableDepth(MIDDLE);

        DisplayableDepth biggest = new DisplayableDepth(HIGHEST);

        int compareSmallestAndMiddle = smallest.compareTo(middle);
        boolean smallestIsSmallerThanMiddle = compareSmallestAndMiddle < 0;

        int compareSmallestAndBiggest = smallest.compareTo(biggest);
        boolean smallestIsSmallerThanBiggest = compareSmallestAndBiggest < 0;

        int compareMiddleAndBiggest = middle.compareTo(biggest);
        boolean middleIsSmallerThanBiggest = compareMiddleAndBiggest < 0;

        return smallestIsSmallerThanMiddle && smallestIsSmallerThanBiggest && middleIsSmallerThanBiggest;
    }

    public static void testOnTopOfEachOther() {
        TestFrame myFrame = new TestFrame();

        myFrame.addDisplayable(new DisplayableShapeFilled(DisplayableDepth.HIGHEST,
                new BoundingArea(150, 150, 50, 50), Color.RED));
        myFrame.addDisplayable(new DisplayableShapeFilled(DisplayableDepth.BACKGROUND,
                new BoundingArea(0, 0, 500, 500), Color.BLUE));
        myFrame.addDisplayable(new DisplayableShapeFilled(DisplayableDepth.MIDDLE,
                new BoundingArea(100, 100, 100, 100), Color.BLACK));


        while (true) {
            myFrame.update();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
