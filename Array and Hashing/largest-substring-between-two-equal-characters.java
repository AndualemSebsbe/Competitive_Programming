class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        int res = -1, r = n - 1;

        for(int l = 0; l < n - 1; l++){
            while(l < r){
                if(s.charAt(l) == s.charAt(r)){
                    res = Math.max(res, r - l - 1);
                    break;
                }
                else
                    r -= 1;
            }

            r = n - 1;
        }

        return res;
    }
}