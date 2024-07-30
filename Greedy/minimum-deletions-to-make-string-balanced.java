class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int totalA = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'a')
                totalA += 1;
        }

        int min = Integer.MAX_VALUE;
        int countA = 0, countB = 0;
        for(int i = 0; i < n; i++){
            int cur = 0;
            cur += countB; // add num of B's before the current index
            
            if(s.charAt(i) == 'a')
                countA += 1;
            else
                countB += 1;

            cur += (totalA - countA); // add num of A's after the current index
            min = Math.min(min, cur);
        }

        return min;
    }
}