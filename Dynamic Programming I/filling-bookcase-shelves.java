class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        for(int i = n - 1; i >= 0; i--){
            int curWidth = shelfWidth, maxHeight = 0;
            dp[i] = Integer.MAX_VALUE;

            for(int j = i; j < books.length; j++){
                int width = books[j][0], height = books[j][1];
                if(curWidth < width)
                    break;
                
                curWidth -= width;
                maxHeight = Math.max(maxHeight, height);

                dp[i] = Math.min(dp[i], maxHeight + dp[j + 1]);
            }
        }

        return dp[0];
    }
}