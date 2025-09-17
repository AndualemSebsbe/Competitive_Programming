class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] ans = new long[n];

        Map<Integer, Long> idToFreqMap = new HashMap();
        TreeMap<Long, Integer> freqToIDCount = new TreeMap();
        for(int i = 0; i < n; i++){
            long curFreq = idToFreqMap.getOrDefault(nums[i], 0L);
            int IDCount = freqToIDCount.getOrDefault(curFreq, 0);
            
            if(curFreq != 0){
                freqToIDCount.put(curFreq, IDCount - 1);
                if(freqToIDCount.get(curFreq) == 0)
                    freqToIDCount.remove(curFreq);
            }
            
            idToFreqMap.put(nums[i], curFreq + freq[i]);
            curFreq = idToFreqMap.get(nums[i]);
            IDCount = freqToIDCount.getOrDefault(curFreq, 0);
            freqToIDCount.put(curFreq, IDCount + 1);
            ans[i] = freqToIDCount.lastKey(); 
        }
        
        return ans;
    }
}