package adventOfCode2024Day2.java;

import java.util.List;

public abstract class Report {

    // -----------------------------------------------
    // -                  PROPRIETES                 -
    // -----------------------------------------------

    /**
     * Order
     * true : ascending
     * false : descending
     */
    private boolean order;

    /**
     * Levels
     */
    private List<Integer> levels;

    // -----------------------------------------------
    // -                CONSTRUCTEURS                -
    // -----------------------------------------------

    public Report(boolean order, List<Integer> levels) {
        this.order = order;
        this.levels = levels;
    }

    // -----------------------------------------------
    // -               GETTERS/SETTERS               -
    // -----------------------------------------------

    public boolean getOrder() {
        return order;
    }

    public void setOrder(boolean order) {
        this.order = order;
    }

    public List<Integer> getLevels() {
        return levels;
    }

    public void setLevels(List<Integer> levels) {
        this.levels = levels;
    }

    // -----------------------------------------------
    // -                   METHODES                  -
    // -----------------------------------------------

    public abstract boolean isSafePart1();

    public abstract boolean isSafePart2();

    public abstract boolean isNotOkay(Integer i1, Integer i2);
}
