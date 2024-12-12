package adventOfCode2024Day7.java.Part2;

public class EquationPart2 {

    // -----------------------------------------------
    // -                  PROPRIETES                 -
    // -----------------------------------------------

    private Long result;

    private Long[] elems;

    // -----------------------------------------------
    // -                CONSTRUCTEURS                -
    // -----------------------------------------------

    public EquationPart2(Long result, Long[] elems) {
        this.result = result;
        this.elems = elems;
    }

    // -----------------------------------------------
    // -               GETTERS/SETTERS               -
    // -----------------------------------------------

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    public Long[] getElems() {
        return elems;
    }

    public void setElems(Long[] elems) {
        this.elems = elems;
    }

    // -----------------------------------------------
    // -                   METHODES                  -
    // -----------------------------------------------

    public boolean findResult() {
//        System.out.println("Elements = " + Arrays.toString(elems));
        return findResultRecursive(elems, result);
    }

    private boolean findResultRecursive(Long[] elems, Long target) {
        if (elems.length == 1) {
            return elems[0].equals(target);
        }

        for (OperationPart2 op : OperationPart2.values()) {
            Long[] newElems = new Long[elems.length - 1];
            newElems[0] = op.getOperation().apply(elems[0], elems[1]);
            System.arraycopy(elems, 2, newElems, 1, (elems.length - 2));

            if (findResultRecursive(newElems, target)) {
                return true;
            }
        }
        return false;
    }
}
