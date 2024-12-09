package adventOfCode2024Day6.java.part2;

public enum TileTypePart2 {

    WALL('#'),
    EMPTY('.'),
    VISITED('X'),
    GUARD('^');


    private final char symbol;

    TileTypePart2(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static TileTypePart2 fromSymbol(char symbol) {
        for (TileTypePart2 tileTypePart2 : TileTypePart2.values()) {
            if (tileTypePart2.symbol == symbol) {
                return tileTypePart2;
            }
        }
        return null;
    }
}
