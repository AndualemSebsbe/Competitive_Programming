class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0, n = s.length - 1, m = g.length - 1;
        while(n >= 0 && m >= 0){
            if(s[n] >= g[m]){
                count += 1;
                n -= 1;
            }
            
            m -= 1;
        }

        return count;
    }
}