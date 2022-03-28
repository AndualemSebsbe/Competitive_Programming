import java.util.HashMap;

class minOperations {
    public int minimumOperations(int[] nums) {
        
        HashMap<Integer, Integer> evenMap = new HashMap<>();
        HashMap<Integer, Integer> oddMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0)
                evenMap.put(nums[i], evenMap.getOrDefault(nums[i], 0) + 1);     
            else
                oddMap.put(nums[i], oddMap.getOrDefault(nums[i], 0) + 1);
        }
        int evenMax = 0, oddMax = 0, key = 0;
        for(int i : evenMap.keySet()){
            if(evenMax < evenMap.get(i)){
                evenMax = evenMap.get(i);
                key = i;
            }
        }
        
        for(int i : oddMap.keySet()){
            if(i != key)
                oddMax = Math.max(oddMax, oddMap.get(i));
        }
       int minOperation1 = nums.length - oddMax - evenMax;
        
       evenMax = oddMax = key = 0;
        for(int i : oddMap.keySet()){
            if(oddMax < oddMap.get(i)){
                oddMax = oddMap.get(i);
                key = i;
            }
        }
        
        for(int i : evenMap.keySet()){
            if(i != key)
                evenMax = Math.max(evenMax, evenMap.get(i));
        }
       int minOperation2 = nums.length - oddMax - evenMax;
    
       return Math.min(minOperation1, minOperation2);
    }
}