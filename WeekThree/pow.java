public class pow {
    
        public double myPow(double x, long n) {
            if(n> 0 ){
                return helper(x, n);
            }
           
            
            return helper(1/x,Math.abs(n) );
        }
        public double helper(double x, long n){
                    if(n==0){
                return 1;
            }
                 double res = myPow(x, n/2);
                if(n%2 != 0){             
               return x*res*res;
                }
                else {
               return res*res;
                }
            
        }
    }