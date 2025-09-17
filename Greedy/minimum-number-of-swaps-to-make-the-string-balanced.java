class Solution {
    public int minSwaps(String s) {
        int maxClose = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == '[')
                close -= 1;
            else 
                close += 1;
            
            maxClose = Math.max(close, maxClose);
        }

        return (maxClose + 1) / 2;
    }
}