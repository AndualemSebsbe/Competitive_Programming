class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b));
        for(int key : map.keySet()){
            int occ = map.get(key);
            while(occ-- > 0)
                pq.add(key);
        }

        int n = nums.length, idx = 0;
        int[] res = new int[n];
        while(!pq.isEmpty())
            res[idx++] = pq.poll();
             
        return res;
    }
}