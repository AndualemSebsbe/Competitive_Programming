class Solution {
    public int findTheWinner(int n, int k) {
        Set<Integer> set = new HashSet();
        int i = 1, count = 0;
        while(set.size() < n - 1){
            if(i > n)
                i = 1;
            if(!set.contains(i))
                count += 1;
            if(count == k){
                set.add(i);
                count = 0;
            }

            i += 1;
        }

        int winner = 1;
        for(int j = 1; j <= n; j++){
            if(!set.contains(j))
                winner = j;
        }

        return winner;
    }
}