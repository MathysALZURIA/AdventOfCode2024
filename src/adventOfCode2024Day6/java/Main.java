package adventOfCode2024Day6.java;

import adventOfCode2024Day6.java.part1.LaboratoryPart1;
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
        String problem = "Guard Gallivant";

        // input data retrieval
        Path input = Paths.get(Main.class.getResource("/input").toURI());

        // Part 1
        PrintTools.printAnswer(6, 1, problem, part1(input));

        // Part 2
        PrintTools.printAnswer(6, 2, problem, part2(input));
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

        LaboratoryPart1 laboratoryPart1 = new LaboratoryPart1(array);

        // data processing
        laboratoryPart1.print();
        laboratoryPart1.runGuard();
        laboratoryPart1.print();

        return Integer.toString(laboratoryPart1.countVisited());
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

        LaboratoryPart1 laboratoryPart1 = new LaboratoryPart1(array);

        // data processing
        laboratoryPart1.print();
        laboratoryPart1.runGuard();
        laboratoryPart1.print();

        return Integer.toString(laboratoryPart1.countVisited());
    }
}
