class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int max = 0, n = s.length();
        int l = 0, r = 0;

        while(r < n){
            while(r < n && maxCost >= Math.abs(s.charAt(r) - t.charAt(r))){
                maxCost -= Math.abs(s.charAt(r) - t.charAt(r));
                r += 1;
            }

            max = Math.max(max, r - l);
            if(r != l)
                maxCost += Math.abs(s.charAt(l) - t.charAt(l));
            else
                r += 1;
            l += 1;
        }

        return max;
    }
}