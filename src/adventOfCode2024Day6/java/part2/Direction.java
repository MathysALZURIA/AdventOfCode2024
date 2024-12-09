package adventOfCode2024Day6.java.part2;

public enum Direction {

    TOP,
    BOTTOM,
    RIGHT,
    LEFT;


    public Direction next() {
        switch (this) {
            case TOP:
                return RIGHT;
            case RIGHT:
                return BOTTOM;
            case BOTTOM:
                return LEFT;
            case LEFT:
                return TOP;
        }
        return null;
    }
}
