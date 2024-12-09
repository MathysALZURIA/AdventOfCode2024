package adventOfCode2024Day6.java.part2;

public class LaboratoryPart2 {

    // -----------------------------------------------
    // -                  PROPRIETES                 -
    // -----------------------------------------------

    /**
     * The laboratory
     */
    private TilePart2[][] laboratory;

    /**
     * The directions facing the guard
     * top, bottom, right, left
     */
    private Direction guardDirection;

    /**
     * The guard position
     */
    private int[] positionGuard;

    /**
     * The number of possible obstructions
     */
    private int obstructionCount;


    // -----------------------------------------------
    // -                CONSTRUCTEURS                -
    // -----------------------------------------------

    public LaboratoryPart2(String[][] laboratory) {

        TilePart2[][] laboratoryTilePart2 = new TilePart2[laboratory.length][laboratory.length];

        for (int i = 0; i < laboratory.length; i++) {
            for (int j = 0; j < laboratory.length; j++) {
                laboratoryTilePart2[i][j] = new TilePart2(laboratory[i][j].charAt(0));
                if (laboratory[i][j].charAt(0) == '^') {
                    this.positionGuard = new int[]{i, j};
                }
            }
        }

        this.laboratory = laboratoryTilePart2;
        this.guardDirection = Direction.TOP;
        this.obstructionCount = 0;
    }

    // -----------------------------------------------
    // -               GETTERS/SETTERS               -
    // -----------------------------------------------

    // -----------------------------------------------
    // -                   METHODES                  -
    // -----------------------------------------------

    /**
     * Print the laboratory
     */
    public void print() {
        for (TilePart2[] tilePart2s : laboratory) {
            for (TilePart2 tilePart2 : tilePart2s) {
                System.out.print(tilePart2.getType().getSymbol());
            }
            System.out.println();
        }
    }

    /**
     * Move the guard
     */
    public void moveGuard() throws ArrayIndexOutOfBoundsException {
        switch (guardDirection) {
            case Direction.TOP:
                if (laboratory[positionGuard[0] - 1][positionGuard[1]].getType() != TileTypePart2.WALL) {
                    laboratory[positionGuard[0]][positionGuard[1]].setType(TileTypePart2.VISITED);
                    positionGuard[0]--;
                } else {
                    guardDirection = guardDirection.next();
                }
                break;
            case Direction.BOTTOM:
                if (laboratory[positionGuard[0] + 1][positionGuard[1]].getType() != TileTypePart2.WALL) {
                    laboratory[positionGuard[0]][positionGuard[1]].setType(TileTypePart2.VISITED);
                    positionGuard[0]++;
                } else {
                    guardDirection = guardDirection.next();
                }
                break;
            case Direction.RIGHT:
                if (laboratory[positionGuard[0]][positionGuard[1] + 1].getType() != TileTypePart2.WALL) {
                    laboratory[positionGuard[0]][positionGuard[1]].setType(TileTypePart2.VISITED);
                    positionGuard[1]++;
                } else {
                    guardDirection = guardDirection.next();
                }
                break;
            case Direction.LEFT:
                if (laboratory[positionGuard[0]][positionGuard[1] - 1].getType() != TileTypePart2.WALL) {
                    laboratory[positionGuard[0]][positionGuard[1]].setType(TileTypePart2.VISITED);
                } else {
                    guardDirection = guardDirection.next();
                }
                break;
        }
    }

    /**
     * Run the guard until he is out of the laboratory
     */
    public void runGuard() {
        try {
            while (true) {
                moveGuard();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The guard is out of the laboratory");
        }
    }

    /**
     * Count the number of visited tiles
     */
    public int countVisited() {
        int count = 0;
        for (TilePart2[] tilePart2s : laboratory) {
            for (TilePart2 tilePart2 : tilePart2s) {
                if (tilePart2.getType() == TileTypePart2.VISITED) {
                    count++;
                }
            }
        }
        return count + 1;
    }
}
