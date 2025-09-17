class Solution {
    int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        backtrack(cookies, 0, k, new int[k]);
        return res;
    }

    void backtrack(int[] cookies, int cur, int k, int[] children){
        if(cur == cookies.length){
            int max = 0;
            for(int child : children)
                max = Math.max(max, child);
            res = Math.min(res, max);
            return;
        }

        for(int i = 0; i < k; i++){
            children[i] += cookies[cur];
            backtrack(cookies, cur+1, k, children);
            children[i] -= cookies[cur];
        }
    }
}