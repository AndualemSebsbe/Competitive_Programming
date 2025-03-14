class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        for (int candie : candies)
            max = Math.max(max, candie);

        int l = 1, r = max;
        int best = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canAllocate(candies, mid, k)) {
                best = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }

        return best;
    }

    boolean canAllocate(int[] candies, int mid, long k) {
        long numChild = 0;
        for (int candie : candies) {
            if (mid != 0)
                numChild += candie / mid;
        }
        
        return numChild >= k;
    }
}