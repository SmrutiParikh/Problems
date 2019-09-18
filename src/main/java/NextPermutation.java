
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class NextPermutation {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3, 2, 1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(1, 1, 5));
        ArrayList<Integer> d = new ArrayList<>(Arrays.asList(20, 30, 113));
        ArrayList<Integer> e = new ArrayList<>(Arrays.asList( 251, 844, 767, 778, 658, 337, 10, 252, 632, 262, 707, 506, 701, 475, 410, 696, 631, 903, 516, 149, 344, 101, 42, 891, 991));
        nextPermutation(a);
        nextPermutation(b);
        nextPermutation(c);
        nextPermutation(d);
        nextPermutation(e);
    }
    private static void nextPermutation(ArrayList<Integer> a) {
        if (a.size() < 2) {
            return;
        }
        int last = a.size() -2;
        while(last >= 0){
            if(a.get(last) < a.get(last+1)){
                break;
            }
            last--;
        }
        if(last < 0){
            Collections.sort(a);
            return;
        }

        int nextGreater = a.size() - 1;
        for (int i = a.size()-1 ; i > last; i--){
            if(a.get(i) > a.get(last)){
                nextGreater = i;
                break;
            }
        }
        swap(a, nextGreater, last);
        reverse(a, last +1, a.size() -1);
        System.out.println(StringUtils.join(a, ","));
    }

    private static void swap(ArrayList<Integer> a, int left, int right){
        int temp = a.get(left);
        a.set(left, a.get(right));
        a.set(right, temp);
    }
    private static void reverse(ArrayList<Integer> a, int left, int right)
    {

        // Reverse the sub-array
        while (left < right) {
            int temp = a.get(left);
            a.set(left++, a.get(right));
            a.set(right--, temp);
        }
    }


}
