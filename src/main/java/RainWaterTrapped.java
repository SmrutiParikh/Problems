
public class RainWaterTrapped {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{ 0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    private static int trap(final int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = A[0];
        for(int i = 1; i < n; i++){
            left[i] = Math.max(left[i-1], A[i]);
        }

        right[n-1] = A[n-1];
        for(int i = n-2; i >=0; i--){
            right[i] = Math.max(right[i+1], A[i]);
        }

        int water = 0;
        for(int i = 0; i < n ; i++){
            water += Math.min(left[i], right[i]) - A[i];
        }
        return water;
    }
}
