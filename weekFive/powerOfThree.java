class powerOfThree {
    public boolean isPowerOfThree(int n) {
        
        return isPowerOf3((double)n);
    }
    public boolean isPowerOf3(double n){
        if(n <= 0) return false;
        if(n == 1) return true;
        
       return isPowerOf3(n/3);
    }
}
//testcase n = 19684
//return false