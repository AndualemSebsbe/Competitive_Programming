class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        int max = 0, res = 0;
        for(int key : map.keySet()){
            int occ = map.get(key);
            if(occ > n/2){
                if(max < occ){
                    res = key;
                    max = occ;
                }
            }
        }

        return res;
    }
}