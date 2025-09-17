class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int zeroes = 0;
        for(int i = 0; i < n - 1; i++)
            if(s.charAt(i) == '0')
                zeroes += 1;
        
        int ones = 0, max = 0;
        int r = n - 1;
        while(r > 0){
            if(s.charAt(r) == '1')
                ones += 1;
            if(s.charAt(r) == '0' && r != n - 1)
                zeroes -= 1;
            max = Math.max(max, zeroes + ones);
            r -= 1;
        }

        return max;
    }
}