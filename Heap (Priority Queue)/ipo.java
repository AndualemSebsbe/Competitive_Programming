class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < n; i++)
            pqCap.add(new int[]{capital[i], profits[i]});
        
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> b - a);
        int totalProfit = w;
        while(k-- > 0){
            while(!pqCap.isEmpty() && pqCap.peek()[0] <= totalProfit)
                maxProfit.add(pqCap.poll()[1]);
            
            if(maxProfit.isEmpty())
                break;
            
            totalProfit += maxProfit.poll();
        }

        return totalProfit;
    }
}