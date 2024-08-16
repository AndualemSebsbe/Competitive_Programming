class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDist = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (List<Integer> arr : arrays)
            maxHeap.add(arr.get(arr.size() - 1));
        
        for (List<Integer> arr : arrays) {
            int min = arr.get(0), max = maxHeap.peek();
            int lastNum = arr.get(arr.size() - 1);
            if (lastNum == maxHeap.peek()) {
                maxHeap.poll();
                max = maxHeap.peek();
                maxHeap.add(lastNum);
            }

            maxDist = Math.max(maxDist, Math.abs(max - min));
        }

        return maxDist;
    }
}