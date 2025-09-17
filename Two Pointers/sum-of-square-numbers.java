class Solution {
    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int)(Math.sqrt(c));
        while(l <= r){
            long currC = (long)(l * l) + (long)(r * r);
            if(currC > c)
                r -= 1;
            else if(currC < c)
                l += 1;
            else
                return true;
        }

        return false;
    }
}