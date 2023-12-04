class Solution {
    public String largestGoodInteger(String num) {
        int maxGood = -1;
        int count = 1, len = num.length();

        for(int i = 1; i < len; i++){
            if(num.charAt(i) == num.charAt(i-1))
                count += 1;
            else
                count = 1;
            
            if(count == 3){
                maxGood = Math.max(maxGood, num.charAt(i) - '0');
                count = 1;
            }
        }

        String res = "";
        count = 3;
        if(maxGood != -1){
            while(count-- > 0){
                res += maxGood;
            }
        }

        return maxGood == -1 ? "" : res;
    }
}