class Solution {
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet();
        PriorityQueue<Long> minHeap = new PriorityQueue();
        minHeap.add(1L);

        long num = 0;
        int count = 0;
        while (count < n) {
            num = minHeap.poll();
            count += 1;

            if (!set.contains(num * 2)) {
                minHeap.add(num * 2);
                set.add(num * 2);
            }

            if (!set.contains(num * 3)) {
                minHeap.add(num * 3);
                set.add(num * 3);
            }
            
            if (!set.contains(num * 5)) {
                minHeap.add(num * 5);
                set.add(num * 5);
            }
        }

        return (int) num;
    }
}