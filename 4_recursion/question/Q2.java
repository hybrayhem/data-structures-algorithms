package question;

import java.util.ArrayList;
import java.util.List;

public class Q2 {

    public Q2() {
        System.out.printf("%n/* ----------------------------------- Q2 ----------------------------------- */%n%n");
    }

    
    /** 
     * @param array Array of items
     * @param start Lower bound of search
     * @param end Upper bound of search
     * @param result Number of items found in range
     * @return int returns result
     */
    public int itemsBetween(List<Integer> array, int start, int end, int result) {
        if (array.isEmpty())
            return result;

        // if (array.get(0) >= start || array.get(array.size() - 1) <= end) {
        //     return result;
        // }

        int mid = array.get(array.size() / 2);
        System.out.println(array.toString());

        if (end < mid) {
            // go left
            return itemsBetween(array.subList(0, array.lastIndexOf(mid)), start, end, result);
        } else if (start > mid) {
            // go right
            return itemsBetween(array.subList(array.indexOf(mid), array.size() - 1), start, end, result);
        }

        int r = array.get(0);
        if (r < end && r > start)
            result++;
        return itemsBetween(array.subList(1, array.size() - 1), start, end, result);
    }

}
