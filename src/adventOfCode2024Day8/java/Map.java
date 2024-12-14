package adventOfCode2024Day8.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Map {

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

    public Map(String[][] map) {

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
     * Print the map
     */
    public void print() {
        for (Tile[] tiles : map) {
            for (Tile tile: tiles) {
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
