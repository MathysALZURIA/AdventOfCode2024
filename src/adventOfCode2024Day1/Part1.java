package adventOfCode2024Day1;

import tools.PrintTools;

import java.util.ArrayList;
import java.util.Collections;

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
        String data = tools.ReadFile.read("src\\adventOfCode2024Day1" +
                "\\input1.txt");

        // data modification
        String[] lines = data.split("\n");
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split("   ");
            firstList.add(Integer.parseInt(parts[0]));
            secondList.add(Integer.parseInt(parts[1]));
        }

        // sort lists
        Collections.sort(firstList);
        Collections.sort(secondList);

        // data processing
        int result = 0;

        for (int i = 0; i < firstList.size(); i++) {
            result += Math.abs(firstList.get(i) - secondList.get(i));
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
        String answer1 = Integer.toString(part1());

        PrintTools.printAnswer(1, 1, problem, answer1);
    }

}

