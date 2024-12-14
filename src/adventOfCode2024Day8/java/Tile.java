package adventOfCode2024Day8.java;

public class Tile {

    // -----------------------------------------------
    // -                  PROPRIETES                 -
    // -----------------------------------------------

    /**
     * Type of the tile
     */
    private TileType type;

    /**
     * Symbol of the tile
     */
    private char symbol;

    /**
     * Is the tile contains antinode
     */
    private boolean containsAntinode;

    /**
     * Coordinates of the tile
     */
    private int[] coords;

    // -----------------------------------------------
    // -                CONSTRUCTEURS                -
    // -----------------------------------------------

    public Tile(Character character, int x, int y) {
        this.type = character == '.' ? TileType.EMPTY : TileType.ANTENNA;
        this.symbol = character;
        this.containsAntinode = character == '#';
        this.coords = new int[]{x, y};
    }

    // -----------------------------------------------
    // -               GETTERS/SETTERS               -
    // -----------------------------------------------

    public TileType getType() {
        return type;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setContainsAntinode(boolean containsAntinode) {
        this.containsAntinode = containsAntinode;
    }

    // -----------------------------------------------
    // -                   METHODES                  -
    // -----------------------------------------------

    /**
     * Check if the tile contains an antinode
     * @return true if the tile contains an antinode
     */
    public boolean containsAntinode() {
        return containsAntinode;
    }
}
