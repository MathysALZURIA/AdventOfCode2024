package adventOfCode2024Day6.java.part1;

public enum TileTypePart1 {

    WALL('#'),
    EMPTY('.'),
    VISITED('X'),
    GUARD('^');


    private final char symbol;

    TileTypePart1(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static TileTypePart1 fromSymbol(char symbol) {
        for (TileTypePart1 tileTypePart1 : TileTypePart1.values()) {
            if (tileTypePart1.symbol == symbol) {
                return tileTypePart1;
            }
        }
        return null;
    }
}
