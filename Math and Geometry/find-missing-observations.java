class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int rollsSum = 0;
        for (int roll : rolls)
            rollsSum += roll;
        
        int nSum = mean * (n + m) - rollsSum;
        if (nSum < n || n * 6 < nSum)
            return new int[0];
        
        int rem = nSum % n;
        int division = nSum / n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) 
            res[i] = division;
        
        int i = 0;
        while (rem-- > 0)
            res[i++] += 1;
        
        return res;
    }
}