import org.apache.commons.lang3.StringUtils;

public class SpiralOrderMatrix {
    public static void main(String[] args) {
        System.out.println(StringUtils.join(generateMatrix(3)));
        System.out.println(StringUtils.join(generateMatrix(4)));
    }
    private static int[][] generateMatrix(int A) {
        int k = 0, l = 0, m = A, n = A;
        int num = 1;
        int[][] a = new int[A][A];
        while(k < m && l < n){
            for(int i = l; i < n; i++){
                a[k][i] = num++;
            }
            k++;

            for(int i = k; i < m; i++){
                a[i][n-1] = num++;
            }
            n--;

            if(k < m){
                for(int i = n-1; i >= l; i--){
                    a[m-1][i] = num++;
                }
                m--;
            }
            if(l < n){
                for(int i = m-1; i >= k; i--){
                    a[i][l] = num++;
                }
                l++;
            }
        }
        return a;
    }
}
