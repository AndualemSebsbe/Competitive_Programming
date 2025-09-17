class powerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // if(n <= 0) return false;
        long i = 1;
        
        while(i < n){
            i = (i << 1);
        }
        return i == n;
    }
}