class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1, r = quantities[0];
        for (int quantity : quantities) {
            if (quantity > r)
                r = quantity;
        }
        
        int best = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (canDistribute(n, quantities, mid)) {
                best = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        return best;
    }

    boolean canDistribute(int n, int[] quantities, int numPros) {
        int stores = 0;
        for (int quantity : quantities) 
            stores += Math.ceil(quantity / (double) numPros);

        return stores <= n;
    }
}