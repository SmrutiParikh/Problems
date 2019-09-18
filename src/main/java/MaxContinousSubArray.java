import java.util.Arrays;

public class MaxContinousSubArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, -10};
        int[] b = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(b));
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int maxSubArray(final int[] A) {
        int overAllMax = 0, max = 0;
        for (int aA : A) {
            max += aA;
            if (max < 0) {
                max = 0;
            }
            if (overAllMax < max) {
                overAllMax = max;
            }
        }
        if(overAllMax == 0){
            return Arrays.stream(A).max().orElse(0);
        }
        return overAllMax;
    }
}
