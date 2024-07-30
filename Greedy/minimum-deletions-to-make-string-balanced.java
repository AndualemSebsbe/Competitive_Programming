class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int countA = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'a')
                countA += 1;
        }

        int min = Integer.MAX_VALUE;
        int leftA = 0, leftB = 0;
        for(int i = 0; i < n; i++){
            int cur = 0;
            cur += leftB; // add num of B's before the current index
            
            if(s.charAt(i) == 'a')
                leftA += 1;
            else
                leftB += 1;
            int rightA = countA - leftA; // num of A's after the current index
            cur += rightA; 
            min = Math.min(min, cur);
        }

        return min;
    }
}