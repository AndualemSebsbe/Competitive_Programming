class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;

        return isPowerOf2(n);
    }

    boolean isPowerOf2(int n){
        if(n == 1)
            return true;

        if(n % 2 != 0)
            return false;

        n /= 2;
        return isPowerOf2(n);
    }
}