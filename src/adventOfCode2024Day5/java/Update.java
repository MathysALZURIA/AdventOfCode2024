package adventOfCode2024Day5.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Update {

    // -----------------------------------------------
    // -                  PROPRIETES                 -
    // -----------------------------------------------

    private ArrayList<Integer> listUpdate;

    private ArrayList<Integer> beforeCurent;

    private ArrayList<Integer> afterCurent;

    private Integer curentPage;

    // -----------------------------------------------
    // -                CONSTRUCTEURS                -
    // -----------------------------------------------

    /**
     * Constructor
     * @param listUpdate
     */
    public Update(List<Integer> listUpdate) {
        this.listUpdate = new ArrayList<>(listUpdate);
        this.beforeCurent = new ArrayList<>();
        this.afterCurent = new ArrayList<>(listUpdate);
    }

    // -----------------------------------------------
    // -               GETTERS/SETTERS               -
    // -----------------------------------------------

    public ArrayList<Integer> getListUpdate() {
        return listUpdate;
    }

    public void setListUpdate(ArrayList<Integer> listUpdate) {
        this.listUpdate = listUpdate;
    }

    public ArrayList<Integer> getBeforeCurent() {
        return beforeCurent;
    }

    public void setBeforeCurent(ArrayList<Integer> beforeCurent) {
        this.beforeCurent = beforeCurent;
    }

    public ArrayList<Integer> getAfterCurent() {
        return afterCurent;
    }

    public void setAfterCurent(ArrayList<Integer> afterCurent) {
        this.afterCurent = afterCurent;
    }

    public Integer getCurentPage() {
        return curentPage;
    }

    public void setCurentPage(Integer curentPage) {
        this.curentPage = curentPage;
    }

    // -----------------------------------------------
    // -                   METHODES                  -
    // -----------------------------------------------

    /**
     * Switch to the next page of the update
     * @return true if it works, else false
     */
    public boolean next() {
        if (curentPage == null) {
            this.curentPage = listUpdate.getFirst();
            this.afterCurent.removeFirst();
            return true;
        } else if (afterCurent.isEmpty()) {
            return false;
        } else {
            this.beforeCurent.add(curentPage);
            this.curentPage = afterCurent.getFirst();
            this.afterCurent.removeFirst();
            return true;
        }
    }

    public boolean isOkay(HashMap<Integer, List<Integer>> rulesBefore, HashMap<Integer, List<Integer>> rulesAfter) {
        Update copy = new Update(listUpdate);
        boolean isKo = false;

        while (copy.next()) {
            if (copy.getBeforeCurent().stream().anyMatch(rulesAfter.getOrDefault(copy.getCurentPage(), new ArrayList<>())::contains)) {
                isKo = true;
            } else if (copy.getAfterCurent().stream().anyMatch(rulesBefore.getOrDefault(copy.getCurentPage(), new ArrayList<>())::contains)) {
                isKo = true;
            }
        }

        return !isKo;
    }

    public boolean replace(HashMap<Integer, List<Integer>> rulesBefore, HashMap<Integer, List<Integer>> rulesAfter) {
        Update copy = new Update(listUpdate);

        while(isOkay(rulesBefore, rulesAfter)) {
            if (copy.getBeforeCurent().stream().anyMatch(rulesAfter.getOrDefault(copy.getCurentPage(), new ArrayList<>())::contains)) {
                copy.getBeforeCurent().remove(copy.getCurentPage());
                copy.getAfterCurent().add(copy.getCurentPage());
                copy.setCurentPage(copy.getBeforeCurent().get(copy.getBeforeCurent().size() - 1));
            } else if (copy.getAfterCurent().stream().anyMatch(rulesBefore.getOrDefault(copy.getCurentPage(), new ArrayList<>())::contains)) {
                copy.getAfterCurent().remove(copy.getCurentPage());
                copy.getBeforeCurent().add(copy.getCurentPage());
                copy.setCurentPage(copy.getAfterCurent().get(0));
            } else {
                copy.next();
            }
        }
        return true;
    }

    /**
     * get the Integer in the middle of the list
     * @return Integer
     */
    public Integer getMiddle() {
        return listUpdate.get(listUpdate.size() / 2);
    }

    @Override
    public String toString() {
        return "Update{" +
                "listUpdate=" + listUpdate +
                ", beforeCurent=" + beforeCurent +
                ", afterCurent=" + afterCurent +
                ", curentPage=" + curentPage +
                '}';
    }
}
