class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        Integer[] memo = new Integer[n];
        return minHeight(books, 0, shelfWidth, memo);
    }

    int minHeight(int[][] books, int i, int shelfWidth, Integer[] memo){
        if(i == books.length)
            return 0;

        if(memo[i] != null)
            return memo[i];
        
        int curWidth = shelfWidth, maxHeight = 0;
        int res = Integer.MAX_VALUE;
        for(int j = i; j < books.length; j++){
            if(curWidth < books[j][0])
                break;
            
            curWidth -= books[j][0];
            maxHeight = Math.max(maxHeight, books[j][1]);

            res = Math.min(res, maxHeight + minHeight(books, j + 1, shelfWidth, memo));
        }

        return memo[i] = res;
    }
}