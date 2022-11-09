class Solution {
    static HashMap<String, Boolean> map;
    
    public boolean splitArraySameAverage(int[] nums){
        map = new HashMap<>();
        int n = nums.length, total = 0;
        for(int num : nums) total += num;
        
        // For every number of elements -> Find the sum that must be achieved
        for(int len=1; len < n; len++){
            int sum = (len*total)/n;
            
            if((len*total)%n == 0)
                if(canSplit(len,nums,sum,n)) 
                    return true;
        }
        return false;
    }

    public static boolean canSplit(int len, int[] arr, float sum, int n){

        // Create the key for the map
        String key = len + "*" + sum + "*" + n;

        // Base cases
        if(len == 0){
            if(sum==0 && len==0) 
                return true;
             else
                 return false;
        }
        else if(n == 0){
            if(sum == 0 && len == 0)
                return true;
            else
                return false;
        }
        
        // Memoization check
        if(map.containsKey(key)) 
            return map.get(key);

        // Include the element in the sum or exclude the element 
        boolean val = (canSplit(len-1, arr, sum-arr[n-1], n-1)) || (canSplit(len, arr, sum, n-1));
        map.put(key, val);
        return map.get(key);
    }
}