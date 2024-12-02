package adventOfCode2024Day2.java;

import tools.PrintTools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Part1 {

    // -----------------------------------------------
    // -                SOUS PROGRAMMES              -
    // -----------------------------------------------

    /**
     * Part 1
     * @return the answer
     */
    public static int part1() {
        // input data retrieval
        String data = tools.ReadFile.read("src\\adventOfCode2024Day2" +
                "\\input.txt");

        // data modification
        List<String[]> list = data.lines()
                .map(string -> string.split(" ")).toList();

        // data processing
        int result = 0;

        for (String[] strings : list) {
            for (int i = 0; i < strings.length-1; i++) {
                if (strings[i] )
            }
        }

        return result;
    }

    // -----------------------------------------------
    // -             PROGRAMME PRINCIPAL             -
    // -----------------------------------------------

    public static void main(String[] args) {

        // Day 1
        String problem = "Red-Nosed Reports";

        // Part 1
        String answer1 = Integer.toString(part1());

        PrintTools.printAnswer(2, 1, problem, answer1);
    }
}
