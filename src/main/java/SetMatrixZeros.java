import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        for(int i =0; i< a.size(); i++){
            ArrayList<Integer> arr = a.get(i);
            for(int j = 0; j < arr.size(); j++){
                if(arr.get(j) == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(Integer r : row){
            a.set(r, new ArrayList<Integer>(Collections.nCopies(a.get(r).size(), 0)));
        }
        for(Integer c : col ){
            for (ArrayList<Integer> anA : a) {
                anA.set(c, 0);
            }
        }
    }
}
