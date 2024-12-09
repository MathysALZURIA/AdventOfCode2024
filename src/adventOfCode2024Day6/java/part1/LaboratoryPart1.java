package adventOfCode2024Day6.java.part1;

public class LaboratoryPart1 {

    // -----------------------------------------------
    // -                  PROPRIETES                 -
    // -----------------------------------------------

    /**
     * The laboratory
     */
    private TilePart1[][] laboratory;

    /**
     * The directions facing the guard
     * top, bottom, right, left
     */
    private String guardDirection;

    /**
     * The guard position
     */
    private int[] positionGuard;


    // -----------------------------------------------
    // -                CONSTRUCTEURS                -
    // -----------------------------------------------

    public LaboratoryPart1(String[][] laboratory) {

        TilePart1[][] laboratoryTilePart1 = new TilePart1[laboratory.length][laboratory.length];

        for (int i = 0; i < laboratory.length; i++) {
            for (int j = 0; j < laboratory.length; j++) {
                laboratoryTilePart1[i][j] = new TilePart1(laboratory[i][j].charAt(0));
                if (laboratory[i][j].charAt(0) == '^') {
                    this.positionGuard = new int[]{i, j};
                }
            }
        }

        this.laboratory = laboratoryTilePart1;
        this.guardDirection = "top";
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
        for (TilePart1[] tilePart1s : laboratory) {
            for (TilePart1 tilePart1 : tilePart1s) {
                System.out.print(tilePart1.getType().getSymbol());
            }
            System.out.println();
        }
    }

    /**
     * Move the guard
     */
    public void moveGuard() throws ArrayIndexOutOfBoundsException {
        switch (guardDirection) {
            case "top":
                if (laboratory[positionGuard[0] - 1][positionGuard[1]].getType() != TileTypePart1.WALL) {
                    laboratory[positionGuard[0]][positionGuard[1]].setType(TileTypePart1.VISITED);
                    positionGuard[0]--;
                } else {
                    guardDirection = "right";
                }
                break;
            case "bottom":
                if (laboratory[positionGuard[0] + 1][positionGuard[1]].getType() != TileTypePart1.WALL) {
                    laboratory[positionGuard[0]][positionGuard[1]].setType(TileTypePart1.VISITED);
                    positionGuard[0]++;
                } else {
                    guardDirection = "left";
                }
                break;
            case "right":
                if (laboratory[positionGuard[0]][positionGuard[1] + 1].getType() != TileTypePart1.WALL) {
                    laboratory[positionGuard[0]][positionGuard[1]].setType(TileTypePart1.VISITED);
                    positionGuard[1]++;
                } else {
                    guardDirection = "bottom";
                }
                break;
            case "left":
                if (laboratory[positionGuard[0]][positionGuard[1] - 1].getType() != TileTypePart1.WALL) {
                    laboratory[positionGuard[0]][positionGuard[1]].setType(TileTypePart1.VISITED);
                    positionGuard[1]--;
                } else {
                    guardDirection = "top";
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
        for (TilePart1[] tilePart1s : laboratory) {
            for (TilePart1 tilePart1 : tilePart1s) {
                if (tilePart1.getType() == TileTypePart1.VISITED) {
                    count++;
                }
            }
        }
        return count + 1;
    }
}
