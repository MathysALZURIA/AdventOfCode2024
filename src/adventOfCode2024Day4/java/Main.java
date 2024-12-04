package adventOfCode2024Day4.java;

import tools.PrintTools;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    // -----------------------------------------------
    // -             PROGRAMME PRINCIPAL             -
    // -----------------------------------------------

    public static void main(String[] args) throws URISyntaxException, IOException {

        // Day 1
        String problem = "Ceres Search";

        // input data retrieval
        Path input = Paths.get(adventOfCode2024Day4.java.Main.class.getResource("/input").toURI());

        // Part 1
        PrintTools.printAnswer(4, 1, problem, part1(input));

        // Part 2
        PrintTools.printAnswer(4, 2, problem, part2(input));
    }

    // -----------------------------------------------
    // -                SOUS PROGRAMMES              -
    // -----------------------------------------------

    /**
     * Part 1
     *
     * @return the answer
     */
    public static String part1(Path input) throws IOException {

        // data modification
        String[][] array = Files.lines(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        boolean bottomOk = false;
        boolean topOk = false;
        boolean leftOk = false;
        boolean rightOk = false;

        Integer result = 0;

        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                if (array[x][y].equals("X")) {
                    // can I check top, bottom, left, right
                    topOk = (x >= 3);
                    bottomOk = (x <= array.length - 4);
                    leftOk = (y >= 3);
                    rightOk = (y <= array[x].length - 4);

                    // check top
                    if (topOk) {
                        result += array[x-1][y].equals("M") && array[x-2][y].equals("A") && array[x-3][y].equals("S") ? 1 : 0;
                    }
                    // check bottom
                    if (bottomOk) {
                        result += array[x+1][y].equals("M") && array[x+2][y].equals("A") && array[x+3][y].equals("S") ? 1 : 0;
                    }
                    // check left
                    if (leftOk) {
                        result += array[x][y-1].equals("M") && array[x][y-2].equals("A") && array[x][y-3].equals("S") ? 1 : 0;
                    }
                    // check right
                    if (rightOk) {
                        result += array[x][y+1].equals("M") && array[x][y+2].equals("A") && array[x][y+3].equals("S") ? 1 : 0;
                    }
                    // check top left
                    if (topOk && leftOk) {
                        result += array[x-1][y-1].equals("M") && array[x-2][y-2].equals("A") && array[x-3][y-3].equals("S") ? 1 : 0;
                    }
                    // check top right
                    if (topOk && rightOk) {
                        result += array[x-1][y+1].equals("M") && array[x-2][y+2].equals("A") && array[x-3][y+3].equals("S") ? 1 : 0;
                    }
                    // check bottom left
                    if (bottomOk && leftOk) {
                        result += array[x+1][y-1].equals("M") && array[x+2][y-2].equals("A") && array[x+3][y-3].equals("S") ? 1 : 0;
                    }
                    // check bottom right
                    if (bottomOk && rightOk) {
                        result += array[x + 1][y + 1].equals("M") && array[x + 2][y + 2].equals("A") && array[x + 3][y + 3].equals("S") ? 1 : 0;
                    }
                }
            }
        }
        // data processing
        return Integer.toString(result);
    }

    /**
     * Part 2
     *
     * @return the answer
     */
    public static String part2(Path input) throws IOException {

        // data modification
        String[][] array = Files.lines(input)
                .map(line -> line.split(""))
                .toArray(String[][]::new);

        boolean bottomOk = false;
        boolean topOk = false;
        boolean leftOk = false;
        boolean rightOk = false;

        Integer result = 0;

        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                if (array[x][y].equals("A")) {
                    // can I check top, bottom, left, right
                    topOk = (x >= 1);
                    bottomOk = (x <= array.length - 2);
                    leftOk = (y >= 1);
                    rightOk = (y <= array[x].length - 2);

                    // check topp^b
                    if (topOk && bottomOk && leftOk && rightOk) {
                        result += array[x-1][y-1].equals("M") && array[x-1][y+1].equals("M") && array[x+1][y-1].equals("S") && array[x+1][y+1].equals("S")
                                || array[x-1][y-1].equals("S") && array[x-1][y+1].equals("M") && array[x+1][y-1].equals("S") && array[x+1][y+1].equals("M")
                                || array[x-1][y-1].equals("S") && array[x-1][y+1].equals("S") && array[x+1][y-1].equals("M") && array[x+1][y+1].equals("M")
                                || array[x-1][y-1].equals("M") && array[x-1][y+1].equals("S") && array[x+1][y-1].equals("M") && array[x+1][y+1].equals("S") ? 1 : 0;
                    }
                }
            }
        }
        // data processing
        return Integer.toString(result);
    }
}
