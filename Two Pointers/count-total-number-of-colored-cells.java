class Solution {
    public long coloredCells(int n) {
        long res = 1;
        int i = 1, height = 1;
        while (i < n) {
            res += (height * 2);
            res += 2;
            height += 2;
            i += 1;
        }

        return res;        
    }
}