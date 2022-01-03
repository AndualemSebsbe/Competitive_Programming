class countGoodNum {
    public int countGoodNumbers(long n) {
        long res = n%2 == 0?1:5;
        //the good numbers of length 2 
        long x=20;
        for(long indx=n/2; indx>0; indx/=2){
            if(indx%2 != 0) res = res * x %1_000_000_007;
            x= x*x%1_000_000_007;
        }
        return (int)res;
    }
}