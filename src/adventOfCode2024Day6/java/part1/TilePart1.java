package adventOfCode2024Day6.java.part1;

public class TilePart1 {

    // -----------------------------------------------
    // -                  PROPRIETES                 -
    // -----------------------------------------------

    /**
     * Type of the tile
     */
    private TileTypePart1 type;

    // -----------------------------------------------
    // -                CONSTRUCTEURS                -
    // -----------------------------------------------

    public TilePart1(Character type) {
        this.type = TileTypePart1.fromSymbol(type);
    }

    // -----------------------------------------------
    // -               GETTERS/SETTERS               -
    // -----------------------------------------------

    public TileTypePart1 getType() {
        return type;
    }

    public void setType(TileTypePart1 type) {
        this.type = type;
    }

    // -----------------------------------------------
    // -                   METHODES                  -
    // -----------------------------------------------
}
