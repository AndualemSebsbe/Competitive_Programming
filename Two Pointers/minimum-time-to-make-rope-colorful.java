class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int res = 0, l = 0;

        for(int r = 1; r < n; r++){
            if(colors.charAt(r) == colors.charAt(l)){
                if(neededTime[l] < neededTime[r]){
                    res += neededTime[l];
                    l = r;
                }
                else
                    res += neededTime[r];
            }
            else
                l = r;
        }

        return res;
    }
}