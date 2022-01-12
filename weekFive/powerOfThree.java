class powerOfThree {
    public boolean isPowerOfThree(int n) {
        int num = 0;
        if(n <= 0) return false;
        while(n > 1){
            num = n % 3;
            if(num != 0)
                return false;
            n = n/3;
        }
        
        return true;
    }
}
//testcase n = 19684
//return false