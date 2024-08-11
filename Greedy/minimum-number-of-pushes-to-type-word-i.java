class Solution {
    public int minimumPushes(String word) {
        int push = 0, res = 0;
        for (int i = 0; i < word.length(); i++) {
            if (i % 8 == 0)
                push += 1;
            
            res += push;
        }

        return res;
    }
}