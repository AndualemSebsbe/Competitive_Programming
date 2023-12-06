class Solution {
    public int totalMoney(int n) {
        int monday = 1, dollar = 1;
        int res = 0;

        for(int i = 1; i <= n; i++){
            res += monday;
            monday += 1;
            if( i % 7 == 0){ 
                dollar += 1;   
                monday = dollar;
            }
        }

        return res;
    }
}