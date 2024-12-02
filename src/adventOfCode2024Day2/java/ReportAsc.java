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

    public boolean isLevelSafe(List<Integer> levels) {
        boolean result = true;

        for (int i = 0; i < levels.size() - 1; i++) {
            if (isNotOkay(levels.get(i), levels.get(i + 1))) {
                result = false;
            }
        }

        return result;
    }

    @Override
    public boolean isSafePart1() {
        return isLevelSafe(getLevels());
    }

    @Override
    public boolean isSafePart2() {
        boolean result = true;
        List<Integer> levels = getLevels();

        if (isLevelSafe(levels)) {
            return true;
        } else {
            for (int i = 0; i < levels.size(); i++) {
                List<Integer> newLevels = new java.util.ArrayList<>(List.copyOf(levels));
                newLevels.remove(i);

                if (isLevelSafe(newLevels)) {
                    return true;
                }
                result = false;
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
