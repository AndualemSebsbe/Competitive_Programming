class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[52];
        
        for (char c: s.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                int i = c-'A' + 26;
                count[i]++;
            }
            else{
                int i = c - 'a';
                count[i]++;
            }
        }
        
        int ans = 0;
        for(int val : count){
            ans += val/2 * 2;
            if(ans % 2 == 0 && val % 2 == 1)
                ans++;
        }
        
        return ans;
    }
}