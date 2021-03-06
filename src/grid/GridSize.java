package grid;

/**
 * The possible grid sizes in the game
 *
 * @author Jérémie Beaudoin-Dion
 */
public enum GridSize {

    Big(64), Medium(48), Small(32);

    private final int value;

    GridSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
