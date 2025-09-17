class powerOfFour {
    public boolean isPowerOfFour(int n) {        
          
        return isPowerOf4((double)n);
    }
   public boolean isPowerOf4(double n){
        if(n <= 0) return false;
           if(n == 1) return true;
       return isPowerOf4(n/4);
   }
}