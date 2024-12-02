package adventOfCode2024Day2.java;

import java.util.List;

public class ReportAsc extends Report {

    // -----------------------------------------------
    // -                CONSTRUCTEURS                -
    // -----------------------------------------------

    public ReportAsc(boolean order, List<Integer> levels) {
        super(order, levels);
    }

    // -----------------------------------------------
    // -                   METHODES                  -
    // -----------------------------------------------

    @Override
    public boolean isSafePart1() {
        List<Integer> levels = getLevels();
        boolean result = true;
        for (int i = 0; i < levels.size() - 1; i++) {
            if (isNotOkay(levels.get(i), levels.get(i + 1))) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean isSafePart2() {
        List<Integer> levels = getLevels();
        boolean result = true;
        int erreur = 0;

        for (int i = 0; i < levels.size() - 1; i++) {
            if (isNotOkay(levels.get(i), levels.get(i + 1))) {

                erreur++;
                if (erreur > 1) {
                    return false;
                } else if (i == 0) {
                    if (isNotOkay(levels.get(i), levels.get(i + 2))
                            || isNotOkay(levels.get(i + 1), levels.get(i + 2))) {
                        result = false;
                    }
                } else if (i == levels.size() - 2) {
                    if (isNotOkay(levels.get(i - 1), levels.get(i + 1))
                            || isNotOkay(levels.get(i - 1), levels.get(i))) {
                        result = false;
                    }
                } else {
                    if (isNotOkay(levels.get(i - 1), levels.get(i + 1))
                            || isNotOkay(levels.get(i), levels.get(i + 2))) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public boolean isNotOkay(Integer i1, Integer i2) {
        return i2 <= i1
                || i2 > (i1 + 3);
    }
}
