class minNonZeroPro {
    public int minNonZeroProduct(int p) {
        long mod = (long)Math.pow(10, 9) + 7;
        long max = (long)Math.pow(2, p) - 1;
        long power = pow(max-1, (max-1)/2);
        power = ((max%mod)*(power%mod))%mod;
       return (int)power;
    }
    public long pow(long num, long val){
        if(val==0)
            return 1L;
        
        long mod = (long)Math.pow(10, 9) + 7;
        long res = pow(num, val/2);
       
        res = res%mod;
        if(val % 2 == 0){
            return (res*res)%mod;
        }
        else{
            return (((res*res)%mod)*(num%mod))%mod;
        }
    }
}