package question;

import java.util.Collections;
import java.util.List;

public class Q3 {

    public Q3() {
        System.out.printf("%n/* ----------------------------------- Q3 ----------------------------------- */%n%n");
    }

    
    /** 
     * @param array
     * @param sum
     * @param result
     * @return List<Integer>
     */
    public List<Integer> extractSubarray(List<Integer> array, int sum, List<Integer> result){
        if(sum <= 0) return result;

        int r = array.remove(0);
        result.add(r);
        sum-=r;
        return extractSubarray(array, sum, result);
    }

    
    /** 
     * @param array
     * @param sum
     * @return boolean
     */
    public boolean subarrayMatch(List<Integer> array, int sum) {
        if(sum == 0) return true;
        if(array.isEmpty() || sum < 0) return false;

        if(!array.isEmpty() && array.get(0) < sum){
            sum -= array.remove(0);
            return subarrayMatch(array, sum);
        }

        return false;
    }

    
    /** 
     * @param array
     * @param sum
     * @param result
     * @return List<Integer>
     */
    public List<Integer> contiguousSubarray(List<Integer> array, int sum, List<Integer> result) {
        if(array.isEmpty()) return Collections.emptyList();

        if(subarrayMatch(array, sum)){
            return extractSubarray(array, sum, result);
        }

        return contiguousSubarray(array.subList(1, array.size()-1), sum, result);
    }
    
}
