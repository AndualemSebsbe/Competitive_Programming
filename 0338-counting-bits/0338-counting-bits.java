class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        for(int i = 0; i <= n; i++)
            ans[i] = countOfOnes(i);
        
        return ans;
    }
    
    public int countOfOnes(int num){
        int count = 0;
        for(int i = 0; i < 32; i++)
            if(((num >> i) & 1) == 1)
                count += 1;
        
        return count;
    }
}