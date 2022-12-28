import java.util.PriorityQueue;

class removeStone {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int sum = 0;
        for(int pile : piles){
            pq.add(pile);
            sum += pile;
        }

        int removed = 0;
        while(k-- > 0){
            int max = pq.poll();
            if(max%2 == 0)
                pq.add(max/2);
            else
                pq.add(max/2 + 1);
            
            max /= 2;
            removed += max;
        }

        return sum - removed;
    }
}