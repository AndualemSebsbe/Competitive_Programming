//Legendere's 3-Square Theorem
class Solution {
    public int numSquares(int n) {
        double sqrt = Math.sqrt(n);
        if(Math.ceil(sqrt) == Math.floor(sqrt))
            return 1;
        
        while(n % 4 == 0)
            n /= 4;
        if(n % 8 == 7)
            return 4;
        
        for(int i = 1; i*i <= n; i++){
            int base = (int)Math.sqrt(n-i*i);
            if(base*base == (n-i*i))
                return 2;
        }
        
        return 3;
    }
}