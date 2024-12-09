package adventOfCode2024Day6.java.part2;

import java.util.ArrayList;

public class TilePart2 {

    // -----------------------------------------------
    // -                  PROPRIETES                 -
    // -----------------------------------------------

    /**
     * Type of the tile
     */
    private TileTypePart2 type;

    /**
     * The directions the tile was visited
     */
    private ArrayList<Direction> directions;

    // -----------------------------------------------
    // -                CONSTRUCTEURS                -
    // -----------------------------------------------

    public TilePart2(Character type) {
        this.type = TileTypePart2.fromSymbol(type);
        this.directions = new ArrayList<>();
    }

    // -----------------------------------------------
    // -               GETTERS/SETTERS               -
    // -----------------------------------------------

    public TileTypePart2 getType() {
        return type;
    }

    public void setType(TileTypePart2 type) {
        this.type = type;
    }

    public ArrayList<Direction> getDirections() {
        return directions;
    }

    public void setDirections(ArrayList<Direction> directions) {
        this.directions = directions;
    }

    // -----------------------------------------------
    // -                   METHODES                  -
    // -----------------------------------------------
}
