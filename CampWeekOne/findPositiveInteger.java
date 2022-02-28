import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class findPositiveInteger {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> aList = new ArrayList<>();
        
        for(int x = 1; x <= 1000; x++){
            int l = 1;
            int r = 1000;
            
            while(l <= r){
                int mid = l + (r - l)/2;
                int res = customfunction.f(x,mid);
                if(res < z)
                    l = mid + 1;
                else if(res > z)
                    r = mid - 1;
                else{
                    aList.add(Arrays.asList(x, mid));
                    break;
                }
            }
        }
        return aList;
    }
}