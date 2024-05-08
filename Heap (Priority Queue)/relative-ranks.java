class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int num : score)
            pq.add(num);
        
        Map<Integer, String> map = new HashMap();
        if(!pq.isEmpty())
            map.put(pq.poll(), "Gold Medal");
        if(!pq.isEmpty())
            map.put(pq.poll(), "Silver Medal");
        if(!pq.isEmpty())
            map.put(pq.poll(), "Bronze Medal");

        int idx = 4;
        while(!pq.isEmpty()){
            map.put(pq.poll(), idx + "");
            idx += 1;
        }

        int n = score.length, i = 0;
        String[] ans = new String[n];
        for(int key : score)
            ans[i++] = map.get(key);
        
        return ans;
    }
}