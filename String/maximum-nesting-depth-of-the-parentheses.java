class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int open = 0;
        for(char c : s.toCharArray()){
            if(c == '(')
                open += 1;
            else if(c == ')')
                open -= 1;
            
            max = Math.max(max, open);
        }

        return max;
    }
}