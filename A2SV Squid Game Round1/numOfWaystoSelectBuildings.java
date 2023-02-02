class numOfWaystoSelectBuildings {
    public long numberOfWays(String s) {
        long zero = 0, one = 0, zeroOne = 0, oneZero = 0;
        long res = 0;

        for(char c : s.toCharArray()){
            if(c == '0'){
                zero += 1;
                oneZero += one;
                res += zeroOne;
            }
            else{
                one += 1;
                zeroOne += zero;
                res += oneZero;
            }
        }

        return res;
    }
}