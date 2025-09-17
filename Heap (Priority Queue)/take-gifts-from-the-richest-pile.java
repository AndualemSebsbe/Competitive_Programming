class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts)
            maxHeap.add(gift);
        
        while (k-- > 0) {
            int gift = maxHeap.poll();
            int rem = (int) Math.floor(Math.sqrt(gift));
            maxHeap.add(rem);
        }

        long res = 0;
        while(!maxHeap.isEmpty())
            res += maxHeap.poll();
        
        return res;
    }
}