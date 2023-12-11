class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int max = bloomDay[0];
        for(int num : bloomDay){
            if(num >  max)
                max = num;
        }

        int l = 1, r = max;
        int best = -1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(maxBouquets(bloomDay, mid, k) >= m){
                best = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        return best;
    }

    int maxBouquets(int[] bloomDay, int mid, int k){
        int count = 0;
        int adj = 0;

        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= mid)
                adj += 1;
            else
                adj = 0;
            
            if(adj == k){
                count += 1;
                adj = 0;
            }
        }

        return count;
    }
}