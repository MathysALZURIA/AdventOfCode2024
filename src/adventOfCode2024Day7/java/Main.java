package adventOfCode2024Day7.java;

import adventOfCode2024Day7.java.Part1.Equation;
import adventOfCode2024Day7.java.Part2.EquationPart2;
import tools.PrintTools;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    // -----------------------------------------------
    // -             PROGRAMME PRINCIPAL             -
    // -----------------------------------------------

    public static void main(String[] args) throws URISyntaxException, IOException {

        // Day 1
        String problem = "Bridge Repair";

        // input data retrieval
        Path input = Paths.get(Main.class.getResource("/input").toURI());

        // Part 1
        PrintTools.printAnswer(7, 1, problem, part1(input));

        // Part 2
        PrintTools.printAnswer(7, 2, problem, part2(input));
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
        Equation[] tabEquation = Files.lines(input)
                .map(s -> s.split(": "))
                .map(s -> new Equation(Long.parseLong(s[0]), Arrays.stream(s[1].split(" ")).map(Long::parseLong).toArray(Long[]::new)))
                .toArray(Equation[]::new);

        // data processing
        Long result = 0L;

        for (Equation equation : tabEquation) {
            if (equation.findResult()) {
                result += equation.getResult();
            }
        }

        return Long.toString(result);
    }

    /**
     * Part 2
     *
     * @return the answer
     */
    public static String part2(Path input) throws IOException {

        // data modification
        EquationPart2[] tabEquation = Files.lines(input)
                .map(s -> s.split(": "))
                .map(s -> new EquationPart2(Long.parseLong(s[0]), Arrays.stream(s[1].split(" ")).map(Long::parseLong).toArray(Long[]::new)))
                .toArray(EquationPart2[]::new);

        // data processing
        Long result = 0L;

        for (EquationPart2 equation : tabEquation) {
            if (equation.findResult()) {
                result += equation.getResult();
            }
        }

        return Long.toString(result);
    }
}
