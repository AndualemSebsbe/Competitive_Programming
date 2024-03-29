import java.util.ArrayList;
import java.util.List;

class allSubset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<List<Integer>>();
        
        int n = nums.length;
        for(int mask = 0; mask < (1<<n); mask++){
            List<Integer> currSet = new ArrayList<>();
            for(int j = 0; j < n; j++)
                if((mask & (1<<j)) != 0)
                    currSet.add(nums[j]);   
            allSubsets.add(currSet);
        }
       return allSubsets; 
    }
}