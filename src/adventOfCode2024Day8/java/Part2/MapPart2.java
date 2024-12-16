package adventOfCode2024Day8.java.Part2;

import adventOfCode2024Day8.java.Tile;
import adventOfCode2024Day8.java.TileType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MapPart2 {

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

    public MapPart2(String[][] map) {

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

                        map[x1][y1].setContainsAntinode(true);
                        map[x2][y2].setContainsAntinode(true);

                        int i = 1;
                        while ((x1-verctorX*i >= 0 && x1-verctorX*i < map.length) && (y1-verctorY*i >= 0 && y1-verctorY*i < map.length)) {
                            map[x1-verctorX*i][y1-verctorY*i].setContainsAntinode(true);
                            i++;
                        }

                        int j = 1;
                        while ((x2+verctorX*j >= 0 && x2+verctorX*j < map.length) && (y2+verctorY*j >= 0 && y2+verctorY*j < map.length)) {
                            map[x2+verctorX*j][y2+verctorY*j].setContainsAntinode(true);
                            j++;
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
