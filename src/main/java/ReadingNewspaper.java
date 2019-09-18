public class ReadingNewspaper {
    public static void main(String[] args) {
        System.out.println(solve(100, new int[]{ 15, 20, 20, 15, 10, 30, 45}));
        System.out.println(solve(2, new int[]{ 1, 0, 0, 0, 0, 0, 0}));
        System.out.println(solve(50, new int[]{ 10, 1, 10, 1, 10, 1, 10 }));
    }
    private static int solve(int A, int[] B) {
        while(A > 0){
            for(int i = 0; i < B.length ; i++){
                A -= B[i];
                if(A <= 0) {
                    return i+1;
                }
            }
        }
        return 0;
    }
}

