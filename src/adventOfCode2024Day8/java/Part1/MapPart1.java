package adventOfCode2024Day8.java.Part1;

import adventOfCode2024Day8.java.Tile;
import adventOfCode2024Day8.java.TileType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MapPart1 {

    // -----------------------------------------------
    // -                  PROPRIETES                 -
    // -----------------------------------------------

    /**
     * The map
     */
    private Tile[][] map;

    /**
     * Hash Map of the coordinates for each types of antennas
     */
    private HashMap<Character, List<Integer[]>> antennas = new HashMap<>();

    // -----------------------------------------------
    // -                CONSTRUCTEURS                -
    // -----------------------------------------------

    public MapPart1(String[][] map) {

        Tile[][] laboratoryTile = new Tile[map.length][map.length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                laboratoryTile[i][j] = new Tile(map[i][j].charAt(0), i, j);
                if (laboratoryTile[i][j].getType() == TileType.ANTENNA) {
                    antennas.putIfAbsent(laboratoryTile[i][j].getSymbol(), new ArrayList<>());
                    antennas.get(laboratoryTile[i][j].getSymbol()).add(new Integer[]{i, j});
                }
            }
        }

        this.map = laboratoryTile;
    }

    // -----------------------------------------------
    // -               GETTERS/SETTERS               -
    // -----------------------------------------------

    // -----------------------------------------------
    // -                   METHODES                  -
    // -----------------------------------------------

    /**
     * Make the antennas resonate
     */
    public void resonate() {
        antennas.forEach((k, v) -> {
            for (Integer[] coords1 : v) {
                for (Integer[] coords2 : v) {
                    if (!Arrays.equals(coords1, coords2)) {
                        int x1 = coords1[0];
                        int y1 = coords1[1];
                        int x2 = coords2[0];
                        int y2 = coords2[1];
                        int verctorX = x2 - x1;
                        int verctorY = y2 - y1;
                        if ((x1-verctorX >= 0 && x1-verctorX < map.length) && (y1-verctorY >= 0 && y1-verctorY < map.length)) {
                            map[x1-verctorX][y1-verctorY].setContainsAntinode(true);
                        }
                        if ((x2+verctorX >= 0 && x2+verctorX < map.length) && (y2+verctorY >= 0 && y2+verctorY < map.length)) {
                            map[x2+verctorX][y2+verctorY].setContainsAntinode(true);
                        }
                    }
                }
            }
        });
    }

    /**
     * Print the map
     */
    public void print() {
        for (Tile[] tiles : map) {
            for (Tile tile : tiles) {
                if (tile.getType() == TileType.ANTENNA) {
                    System.out.print(tile.getSymbol());
                } else if (tile.containsAntinode()) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    /**
     * Print antenna list
     */
    public void printAntennas() {
        antennas.forEach((k, v) -> {
            System.out.println(k + " : " + v.stream().map(Arrays::toString).reduce((s1, s2) -> s1 + " " + s2).orElse(""));
        });
    }

    /**
     * Count the number of tiles containing an antinode
     */
    public int countAntinodes() {
        int count = 0;
        for (Tile[] tiles : map) {
            for (Tile tile : tiles) {
                if (tile.containsAntinode()) {
                    count++;
                }
            }
        }
        return count;
    }
}
