package adventOfCode2024Day1.java;

import tools.PrintTools;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {

    // -----------------------------------------------
    // -             PROGRAMME PRINCIPAL             -
    // -----------------------------------------------

    public static void main(String[] args) throws URISyntaxException, IOException {

        // Day 1
        String problem = "Historian Hysteria";

        // input data retrieval
        Path input = Paths.get(adventOfCode2024Day3.java.Main.class.getResource("/input").toURI());

        // Part 1
        PrintTools.printAnswer(1, 1, problem, part1(input));

        // Part 2
        PrintTools.printAnswer(1, 2, problem, part2(input));
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
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();

        Files.lines(input)
                .map(s -> s.split(" {3}"))
                .map(strings -> List.of(Integer.parseInt(strings[0]), Integer.parseInt(strings[1])))
                .forEach(integers -> {
                    firstList.add(integers.getFirst());
                    secondList.add(integers.getLast());
                });

        // sort lists
        Collections.sort(firstList);
        Collections.sort(secondList);

        // data processing
        int result = 0;

        for (int i = 0; i < firstList.size(); i++) {
            result += Math.abs(firstList.get(i) - secondList.get(i));
        }

        return Integer.toString(result);
    }

    /**
     * Part 2
     *
     * @return the answer
     */
    public static String part2(Path input) throws IOException {

        // data modification
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();

        Files.lines(input)
                .map(s -> s.split(" {3}"))
                .map(strings -> List.of(Integer.parseInt(strings[0]), Integer.parseInt(strings[1])))
                .forEach(integers -> {
                    firstList.add(integers.getFirst());
                    secondList.add(integers.getLast());
                });

        // data processing
        int result = 0;

        for (Integer integer : firstList) {
            result += integer * Collections.frequency(secondList, integer);
        }

        return Integer.toString(result);
    }
}

