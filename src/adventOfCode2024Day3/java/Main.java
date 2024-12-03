package adventOfCode2024Day3.java;

import tools.PrintTools;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    // -----------------------------------------------
    // -                SOUS PROGRAMMES              -
    // -----------------------------------------------

    /**
     * Part 1
     * @return the answer
     */
    public static int part1() {
        // input data retrieval
        String data = tools.ReadFile.read("src\\adventOfCode2024Day3" +
                "\\ressources\\input.txt");

        // data processing
        String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            matches.add(matcher.group());
        }

        return matches.stream()
                .map(s -> s.substring(4, s.length() - 1).split(","))
                .map(s -> Integer.parseInt(s[0]) * Integer.parseInt(s[1]))
                .mapToInt(i -> i)
                .sum();
    }

    /**
     * Part 2
     * @return the answer
     */
    public static int part2() {
        // input data retrieval
        String data = tools.ReadFile.read("src\\adventOfCode2024Day3" +
                "\\ressources\\input.txt");

        // data processing
        String regexMul = "mul\\(\\d{1,3},\\d{1,3}\\)";
        String regexDo = "do\\(\\)";
        String regexDont = "don't\\(\\)";
        String regex = regexMul + "|" + regexDo + "|" + regexDont;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);
        List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            matches.add(matcher.group());
        }

        Integer result = 0;
        boolean doIt = true;

        for (String match : matches) {
            if (match.matches(regexDo)) {
                doIt = true;
            } else if (match.matches(regexDont)) {
                doIt = false;
            } else if (match.matches(regexMul) && doIt) {
                String[] s = match.substring(4, match.length() - 1).split(",");
                result += Integer.parseInt(s[0]) * Integer.parseInt(s[1]);
            }
        }

        return result;
    }

    // -----------------------------------------------
    // -             PROGRAMME PRINCIPAL             -
    // -----------------------------------------------

    public static void main(String[] args) {

        // Day 1
        String problem = "Mull It Over";

        // Part 1
        String answer1 = Integer.toString(part1());
        PrintTools.printAnswer(2, 1, problem, answer1);

        // Part 2
        String answer2 = Integer.toString(part2());
        PrintTools.printAnswer(2, 2, problem, answer2);
    }
}
