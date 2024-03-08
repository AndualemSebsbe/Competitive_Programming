class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> count = new HashMap();
        int maxOcc = 1;
        for(int num : nums){
            int occ = count.getOrDefault(num, 0) + 1;
            count.put(num, occ);
            maxOcc = Math.max(maxOcc, occ);
        }

        int maxCount = 0;
        for(int key : count.keySet()){
            if(count.get(key) == maxOcc)
                maxCount += maxOcc;
        }

        return maxCount;
    }
}