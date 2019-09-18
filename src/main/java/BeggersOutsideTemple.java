import org.apache.commons.lang3.StringUtils;

public class BeggersOutsideTemple {
    public static void main(String[] args) {
        int[] solve = solve(5, new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}});
        System.out.println(StringUtils.join(solve));
    }
    private static int[] solve(int A, int[][] B) {
        int[] beggers = new int[A];
        for (int[] aB : B) {
            int startIndex = aB[0] - 1;
            int endIndex = aB[1];
            int amount = aB[2];
            for (int j = startIndex; j < endIndex; j++) {
                beggers[j] += amount;
            }
        }
        return beggers;
    }
}
