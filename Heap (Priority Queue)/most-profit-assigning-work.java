class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int n = profit.length;
        for(int i = 0; i < n; i++)
            pq.add(new int[]{difficulty[i], profit[i]});
        
        Arrays.sort(worker);
        int m = worker.length;
        int maxProfit = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < m; i++){
            while(!pq.isEmpty() && pq.peek()[0] <= worker[i])
                maxHeap.add(pq.poll()[1]);
            
            if(maxHeap.isEmpty())
                continue;
            
            maxProfit += maxHeap.peek();
        }

        return maxProfit;
    }
}