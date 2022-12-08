class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        backtrack(result, n, new ArrayList(), map);
        
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, int n, List<Integer> res, Map<Integer, Integer> map){
        if(res.size() == n){
            result.add(new ArrayList(res));
            return;
        }
        
        for(int key : map.keySet()){
            int count = map.get(key);
            if(count == 0)
                continue;

            res.add(key);
            map.put(key, count - 1);

            backtrack(result, n, res, map);
            
            res.remove(res.size()-1);
            map.put(key, count);
        }        
    }
}