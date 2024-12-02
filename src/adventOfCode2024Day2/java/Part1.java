package adventOfCode2024Day2.java;

import tools.PrintTools;

import java.util.List;

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
                "\\ressources\\input.txt");

        // data modification
        List<Report> reports = data.lines()
                .map(string -> string.split(" "))
                .map(strings -> {
                    Integer[] list = new Integer[strings.length];
                    for (int i = 0; i < strings.length; i++) {
                        list[i] = Integer.parseInt(strings[i]);
                    }
                    return list;
                })
                .map(integers ->
                        integers[integers.length-1] > integers[0]
                                ? new ReportAsc(true, List.of(integers))
                                : new ReportDesc(false, List.of(integers)))
                .toList();

        // data processing
        int result = 0;
        for (Report report : reports) {
            if (report.isSafePart1()) {
                result++;
            }
        }

        return result;
    }

    /**
     * Part 2
     * @return the answer
     */
    public static int part2() {
        // input data retrieval
        String data = tools.ReadFile.read("src\\adventOfCode2024Day2" +
                "\\ressources\\input.txt");

        // data modification
        List<Report> reports = data.lines()
                .map(string -> string.split(" "))
                .map(strings -> {
                    Integer[] list = new Integer[strings.length];
                    for (int i = 0; i < strings.length; i++) {
                        list[i] = Integer.parseInt(strings[i]);
                    }
                    return list;
                })
                .map(integers ->
                        integers[integers.length-1] > integers[0]
                                ? new ReportAsc(true, List.of(integers))
                                : new ReportDesc(false, List.of(integers)))
                .toList();

        // data processing
        int result = 0;
        for (Report report : reports) {
            if (report.isSafePart2()) {
                result++;
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

        // Part 2
        String answer2 = Integer.toString(part2());
        PrintTools.printAnswer(2, 2, problem, answer2);
    }
}
