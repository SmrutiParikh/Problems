import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class MaxNonNegativeSubArray {
    public static void main(String[] args) {
        int[] a = {-1, -1, -1, -1, -1};
        int[] b = { -846930886, -1714636915, 424238335, -1649760492 };
        int[] c = { 1967513926, 1540383426, -1303455736, -521595368 };
        int[] d = { 336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421 };
        int[] e = { 0, 0, -1, 0 };
        int[] f = { -54961, 3510, -50805, -82137, -39096, -47421 };
        int[] g = { 756898537, -1973594324, -2038664370, -184803526, 1424268980 };

        System.out.println(getOutput(a));
        System.out.println(getOutput(b));
        System.out.println(getOutput(c));
        System.out.println(getOutput(d));
        System.out.println(getOutput(e));
        System.out.println(getOutput(f));
        System.out.println(getOutput(g));
    }

    private static String getOutput(int[] a){
        return Arrays.stream(maxset(a)).mapToObj(Objects::toString).collect(Collectors.joining(","));
    }

    private static int[] maxset(int[] A) {
        int slowPtr = 0, fastPtr = 0;
        int start = 0, end = 0;
        long maxSum = Long.MIN_VALUE, sum = 0;
        while(fastPtr < A.length){
            if(A[fastPtr] >= 0){
                sum += A[fastPtr];
                fastPtr++;
                continue;
            }

            if(sum > maxSum) {
                start = slowPtr;
                end = fastPtr;
                maxSum = sum;
            }

            if(fastPtr == A.length - 1){
                break;
            }

            slowPtr = fastPtr;
            while( slowPtr < A.length-1 && A[slowPtr] < 0){
                slowPtr++;
            }
            fastPtr = slowPtr + 1;
            sum = A[slowPtr];
        }

        if(sum > maxSum) {
            start = slowPtr;
            end = fastPtr;
            maxSum = sum;
        }

        if(maxSum < 0){
            return new int[]{};
        }

        return Arrays.copyOfRange(A, start, end);
    }
}