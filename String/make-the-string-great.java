class Solution {
    public String makeGood(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for(int r = 0; r < n; r++){
            while(sb.length() > 0 && r < n &&
                Math.abs(sb.charAt(sb.length() - 1) - s.charAt(r)) == 32){
                sb.deleteCharAt(sb.length() - 1);
                r += 1;
            }

            if(r != n)
                sb.append(s.charAt(r));
        }

        return sb.toString();
    }
}