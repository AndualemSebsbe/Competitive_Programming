class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n % k != 0)
            return false;
        
        Map<Integer, Integer> freqMap = new TreeMap();
        for(int key : nums)
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);

            while(freq-- > 0){
                for(int cur = key; cur < key + k; cur++){
                    if(freqMap.getOrDefault(cur, 0) == 0)
                        return false;
                    
                    freqMap.put(cur, freqMap.get(cur) - 1);
                }
            }
        }

        return true;
    }
}