package tools;

public class PrintTools {

    // -----------------------------------------------
    // -                  PROPRIETES                 -
    // -----------------------------------------------

    public static String DIVIDER = "* . ﹢ ˖ ✦ ¸ . ﹢ ° ¸. ° ˖ ･ ·̩ ｡ ☆ ﾟ ＊ ¸* . ﹢ ˖ ✦ ¸ . ﹢ ° ¸. ° ˖ ･ ·̩ ｡ ☆";

    // -----------------------------------------------
    // -                   METHODES                  -
    // -----------------------------------------------

    public static void printAnswer(int day, int part, String problem,
                                   String answer) {
        System.out.println(DIVIDER);
        System.out.println("Day " + day + " - " + problem);
        System.out.println("Part " + part + " : " + answer);
        System.out.println(DIVIDER);
    }

    public static void print2DArray(String[][] array) {
        System.out.println();
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}
