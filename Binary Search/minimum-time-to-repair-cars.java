class Solution {
    public long repairCars(int[] ranks, int cars) {
        // Arrays.sort(ranks);
        int max = 0;
        for(int rank : ranks)
            max = Math.max(max, rank);

        long l = 0;
        long r = (long)(max) * (long)(cars) * (long)(cars);
        long best = -1;
        while(l <= r){
            long mid = l + (r - l) / 2;
            if(numOfCars(ranks, mid) >= cars){
                best = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }

        return best;
    }

    long numOfCars(int[] ranks, long mid){
        int n = ranks.length;
        long count = 0;
        for(int i = 0; i < n; i++){
            count += (long)Math.sqrt(Math.floor(mid / ranks[i]));
        }

        return count;
    }
}