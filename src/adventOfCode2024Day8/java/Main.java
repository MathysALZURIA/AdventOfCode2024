package adventOfCode2024Day8.java;

import adventOfCode2024Day8.java.Part1.MapPart1;
import adventOfCode2024Day8.java.Part2.MapPart2;
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

        MapPart1 mapPart1 = new MapPart1(array);

        // data processing
//        mapPart1.print();
//        mapPart1.printAntennas();
        mapPart1.resonate();
        mapPart1.print();

        return Integer.toString(mapPart1.countAntinodes());
    }

    /**
     * Part 2
     *
     * @return the answer
     */
    public static String part2(Path input) throws IOException {

        // data modification
        String[][] array = Files.lines(input)
                .map(s -> s.split(""))
                .toArray(String[][]::new);

        MapPart2 map = new MapPart2(array);

        // data processing
//        map.print();
//        map.printAntennas();
        map.resonate();
        map.print();

        return Integer.toString(map.countAntinodes());
    }
}
