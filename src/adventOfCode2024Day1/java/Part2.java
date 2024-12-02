package adventOfCode2024Day1.java;

import tools.PrintTools;

import java.util.ArrayList;
import java.util.HashMap;

public class Part2 {

    // -----------------------------------------------
    // -                SOUS PROGRAMMES              -
    // -----------------------------------------------

    /**
     * Part 2
     *
     * @return the answer
     */
    public static int part2() {
        // input data retrieval
        String data = tools.ReadFile.read("src\\adventOfCode2024Day1" +
                "\\input1.txt");

        // data modification
        String[] lines = data.split("\n");
        ArrayList<Integer> firstList = new ArrayList<>();
        HashMap<Integer, Integer> secondList = new HashMap<>();

        for (String line : lines) {
            String[] parts = line.split(" {3}");
            // first list
            firstList.add(Integer.parseInt(parts[0]));

            // second list
            Integer item = Integer.parseInt(parts[1]);
            secondList.putIfAbsent(item, 0);
            secondList.put(item, secondList.get(item) + 1);
        }

        // data processing
        int result = 0;

        for (Integer integer : firstList) {
            result += integer * (secondList.getOrDefault(integer, 0));
        }

        return result;
    }

    // -----------------------------------------------
    // -             PROGRAMME PRINCIPAL             -
    // -----------------------------------------------

    public static void main(String[] args) {

        // Day 1
        String problem = "Historian Hysteria";

        // Part 1
        String answer = Integer.toString(part2());

        PrintTools.printAnswer(1, 2, problem, answer);
    }

}

