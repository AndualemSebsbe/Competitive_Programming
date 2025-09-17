class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        int count = 0;
        for(int key : map.keySet()){
            int val = map.get(key);
            while(val > 0){
                if(val < 2)
                    return -1;

                if(val % 3 == 0)
                    val -= 3;
                else if(val % 2 == 0)
                    val -= 2;
                else if(val - 3 >= 0)
                    val -= 3;
                else if(val - 2 >= 0)
                    val -= 2;
                count += 1;
            }
        }

        return count;
    }
}