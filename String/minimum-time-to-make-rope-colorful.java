class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int sum = neededTime[0], max = neededTime[0];
        int res = 0;

        for(int i = 1; i < n; i++){
            if(colors.charAt(i) == colors.charAt(i - 1)){
                sum += neededTime[i];
                max = Math.max(max, neededTime[i]);
                if(i == n - 1)
                    res += (sum - max);
            }
            else{
                res += (sum - max);
                sum = neededTime[i];
                max = neededTime[i];
            }
        }

        return res;
    }
}