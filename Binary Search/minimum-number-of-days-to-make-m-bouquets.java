class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = 0;
        for(int bloom : bloomDay)
            max = Math.max(max, bloom);
        
        int l = 0, r = max, best = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(numOfBouquet(bloomDay, mid, k) >= m){
                best = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        return best;
    }

    int numOfBouquet(int[] bloomDay, int mid, int k){
        int count = 0, adj = 0;
        for(int num : bloomDay){
            if(num <= mid)
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