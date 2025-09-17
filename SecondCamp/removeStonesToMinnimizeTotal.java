import java.util.PriorityQueue;

class removeStonesToMinimizeTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b > a) ? 1 : a == b ? 0 : -1);
        int sum = 0, removed = 0;
        for(int pile : piles){
            pq.add(pile);
            sum += pile;
        }
        
        while(k-- > 0){
            int max = pq.poll();
            if(max % 2 == 0)
                pq.add(max/2);
            else
                pq.add(max/2+1);
            max /= 2;
            removed += max;
        }
        
        return sum - removed;
    }
}