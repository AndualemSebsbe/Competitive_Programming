class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < n; i++)
            queue.add(i);
        
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            int curIdx = queue.poll();
            res[curIdx] = deck[i];

            if(!queue.isEmpty()){
                queue.add(queue.poll());
            }
        }

        return res;
    }
}