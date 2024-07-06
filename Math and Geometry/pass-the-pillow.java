class Solution {
    public int passThePillow(int n, int time) {
        int val = time / (n - 1);
        int rem = time % (n - 1);

        int res = 0;
        if(val % 2 != 0)
            res = n - rem;
        else
            res = rem + 1;
        
        return res;
    }
}