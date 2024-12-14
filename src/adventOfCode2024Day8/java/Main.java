package adventOfCode2024Day8.java;

import tools.PrintTools;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    // -----------------------------------------------
    // -             PROGRAMME PRINCIPAL             -
    // -----------------------------------------------

    public static void main(String[] args) throws URISyntaxException, IOException {

        // Day 1
        String problem = "Resonant Collinearity";

        // input data retrieval
        Path input = Paths.get(Main.class.getResource("/input").toURI());

        // Part 1
        PrintTools.printAnswer(8, 1, problem, part1(input));

        // Part 2
        PrintTools.printAnswer(8, 2, problem, part2(input));
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
                .map(s -> s.split(""))
                .toArray(String[][]::new);

        Map map = new Map(array);

        // data processing
        map.print();
        map.printAntennas();

        return Integer.toString(map.countAntinodes());
    }

    /**
     * Part 2
     *
     * @return the answer
     */
    public static String part2(Path input) throws IOException {

        // data modification

        // data processing

        return "Noy Yet";
    }
}
