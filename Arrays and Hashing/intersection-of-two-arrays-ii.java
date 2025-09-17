class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap();
        Map<Integer, Integer> map2 = new HashMap();

        for(int num : nums1)
            map1.put(num, map1.getOrDefault(num, 0) + 1); 
        
        for(int num : nums2)
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        
        List<Integer> res = new ArrayList();
        for(int num : map1.keySet()){
            if(map2.containsKey(num)){
                int count = Math.min(map1.get(num), map2.get(num));
                while(count-- > 0){
                    res.add(num);
                }
            }
        }

        int[] ans = new int[res.size()];
        int i = 0;
        for(int val : res)
            ans[i++] = val;
        return ans;
    }
}