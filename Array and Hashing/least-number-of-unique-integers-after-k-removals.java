class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Integer> minHeap = new PriorityQueue((a, b) -> map.get(a) - map.get(b));
        minHeap.addAll(map.keySet());

        while(k > 0){
            int key = minHeap.poll();
            int val = map.get(key);

            if(val <= k)
                map.remove(key);
            k -= val;
        }

        return map.size();
    }
}