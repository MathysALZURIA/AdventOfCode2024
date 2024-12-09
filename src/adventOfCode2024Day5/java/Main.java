package adventOfCode2024Day5.java;

import tools.PrintTools;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    // -----------------------------------------------
    // -             PROGRAMME PRINCIPAL             -
    // -----------------------------------------------

    public static void main(String[] args) throws URISyntaxException, IOException {

        // Day 1
        String problem = "Print Queue";

        // input data retrieval
        Path inputRules = Paths.get(adventOfCode2024Day5.java.Main.class.getResource("/inputRules").toURI());
        Path inputUpdates = Paths.get(adventOfCode2024Day5.java.Main.class.getResource("/inputUpdates").toURI());

        // Part 1
        PrintTools.printAnswer(5, 1, problem, part1(inputRules, inputUpdates));

        // Part 2
        PrintTools.printAnswer(5, 2, problem, part2(inputRules, inputUpdates));
    }

    // -----------------------------------------------
    // -                SOUS PROGRAMMES              -
    // -----------------------------------------------

    /**
     * Part 1
     *
     * @return the answer
     */
    public static String part1(Path inputRules, Path inputUpdates) throws IOException {

        // data modification
        HashMap<Integer, List<Integer>> rulesBefore = new HashMap<>();
        HashMap<Integer, List<Integer>> rulesAfter = new HashMap<>();

        // input of the rules
        Files.lines(inputRules)
                .map(s -> List.of(s.split("[|]")))
                .forEach(strings -> {
                    Integer first = Integer.parseInt(strings.get(0));
                    Integer last = Integer.parseInt(strings.get(1));
                    rulesBefore.putIfAbsent(last, new ArrayList<>());
                    rulesBefore.get(last).add(first);
                    rulesAfter.putIfAbsent(first, new ArrayList<>());
                    rulesAfter.get(first).add(last);
                });

        // input of the updates
        List<Update> updateList = Files.lines(inputUpdates)
                .map(s -> s.split(","))
                .map(strings -> Arrays.stream(strings).map(Integer::parseInt).toList())
                .map(Update::new)
                .toList();

        System.out.println(updateList);

        // data processing
        Integer result = 0;

        for (Update update : updateList) {
            result += update.isOkay(rulesBefore, rulesAfter) ? update.getMiddle() : 0;
        }

        return Integer.toString(result);
    }

    /**
     * Part 2
     *
     * @return the answer
     */
    public static String part2(Path inputRules, Path inputUpdates) throws IOException {

        // data modification
        HashMap<Integer, List<Integer>> rulesBefore = new HashMap<>();
        HashMap<Integer, List<Integer>> rulesAfter = new HashMap<>();

        // input of the rules
        Files.lines(inputRules)
                .map(s -> List.of(s.split("[|]")))
                .forEach(strings -> {
                    Integer first = Integer.parseInt(strings.get(0));
                    Integer last = Integer.parseInt(strings.get(1));
                    rulesBefore.putIfAbsent(last, new ArrayList<>());
                    rulesBefore.get(last).add(first);
                    rulesAfter.putIfAbsent(first, new ArrayList<>());
                    rulesAfter.get(first).add(last);
                });

        // input of the updates
        List<Update> updateList = Files.lines(inputUpdates)
                .map(s -> s.split(","))
                .map(strings -> Arrays.stream(strings).map(Integer::parseInt).toList())
                .map(Update::new)
                .toList();

        System.out.println(updateList);
        updateList = updateList.stream().filter(update -> !update.isOkay(rulesBefore, rulesAfter)).toList();
        System.out.println(updateList);

        // data processing
        Integer result = 0;

        for (Update update : updateList) {
            ArrayList<Integer> ltePagesMan = update.getListUpdate();
            ArrayList<Integer> pages = new ArrayList<>();

            HashMap<Integer, List<Integer>> filteredRules = new HashMap<>();

            for (Map.Entry<Integer, List<Integer>> afterRule : rulesAfter.entrySet()) {
                if (!ltePagesMan.contains(afterRule.getKey())) {
                    continue;
                }

                filteredRules.put(afterRule.getKey(), afterRule.getValue());
            }

            while (filteredRules.size() != 0) {

                int pageFound = -1;

                // on récupère la règle qui n'a pas de pages avant elles
                for (Map.Entry<Integer, List<Integer>> entryToTest : filteredRules.entrySet()) {
                    boolean isOk = true;
                    for (Map.Entry<Integer, List<Integer>> entryChallenge : filteredRules.entrySet()) {
                        isOk &= !entryChallenge.getValue().contains(entryToTest.getKey());
                    }

                    if (isOk) {
                        pageFound = entryToTest.getKey();
                        break;
                    }
                }

                if (pageFound == -1) {
                    throw new RuntimeException("FLOPPESQUE L'ALGO ! ");
                } else {
                    filteredRules.remove(pageFound);
                    pages.add(pageFound);
                }
            }

            ltePagesMan.removeAll(pages);
            ltePagesMan.addAll(pages);
            update.setListUpdate(ltePagesMan);
            update.setBeforeCurent(ltePagesMan);
            update.setAfterCurent(ltePagesMan);

            System.out.println(ltePagesMan);
            if (!update.isOkay(rulesBefore, rulesAfter)) {
                System.out.println("echec " + ltePagesMan);
            };

            result += update.getMiddle();
        }

        return Integer.toString(result);
    }

}
