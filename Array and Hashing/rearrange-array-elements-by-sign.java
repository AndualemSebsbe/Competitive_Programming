class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> posMap = new TreeMap();
        TreeMap<Integer, Integer> negMap = new TreeMap();

        for(int i = 0; i < n; i++){
            if(nums[i] > 0)
                posMap.put(i, nums[i]);
            else
                negMap.put(i, nums[i]);
        }

        int i = 0;
        for(int key : posMap.keySet()){
            nums[i] = posMap.get(key);
            i += 2;
        }

        i = 1;
        for(int key : negMap.keySet()){
            nums[i] = negMap.get(key);
            i += 2;
        }

        return nums;
    }
}