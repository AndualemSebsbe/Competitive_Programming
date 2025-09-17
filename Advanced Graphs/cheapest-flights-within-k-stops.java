import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        for(int[] flight : flights){
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0});

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        while(!q.isEmpty() && k >= 0){
            int size = q.size();
            while(size-- > 0){
                int[] curr = q.poll();
                for(int[] child : graph.get(curr[0])){
                    int childNode = child[0];
                    int price = child[1];

                    if(price + curr[1] < minCost[childNode]){
                        minCost[childNode] = price + curr[1];
                        q.add(new int[]{childNode, minCost[childNode]});
                    }
                }
            }

            k -= 1;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}