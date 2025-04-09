class Solution {
    public double myPow(double x, long n) {
        if (n == 0)
            return 1;

        double res = myPosPow(x, Math.abs(n));

        if (n < 0)
            return 1 / res;
        
        return res;
    }

    double myPosPow(double x, long n) {
        if (n == 1)
            return x;
        
        double half = myPosPow(x, n / 2);
        if (n % 2 == 0) 
            return half * half;
        
        return x * half * half;
    }
}