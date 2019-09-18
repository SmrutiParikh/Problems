import java.util.Arrays;

public class MaximumConsecutiveGap {
    public static void main(String[] args) {
        System.out.println(maximumGap(new int[]{1, 10, 5}));
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int maximumGap(final int[] A) {
        if (A.length < 2) {
            return 0;
        }
        Arrays.sort(A);
        int maxGap = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            int diff = Math.abs(A[i] - A[i - 1]);
            if (diff > maxGap) {
                maxGap = diff;
            }
        }
        return maxGap;
    }
}

