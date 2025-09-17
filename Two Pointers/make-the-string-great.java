class Solution {
    public String makeGood(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int l = -1;

        for(int r = 0; r < n; r++){
            while(sb.length() > 0 && r < n &&
                Math.abs(sb.charAt(l) - s.charAt(r)) == 32){
                sb.deleteCharAt(l);
                l -= 1;
                r += 1;
            }

            if(r != n){
                sb.append(s.charAt(r));
                l += 1;
            }
        }

        return sb.toString();
    }
}