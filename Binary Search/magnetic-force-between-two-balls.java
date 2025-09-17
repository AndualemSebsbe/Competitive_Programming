class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int max = 0;
        for(int pos : position)
            max = Math.max(max, pos);

        int l = 0, r = max - 1;
        int best = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(numOfBalls(position, mid) >= m){
                best = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }

        return best;
    }

    int numOfBalls(int[] position, int mid){
        int prev = 0, count = 1, n = position.length;
        for(int i = 0; i < n; i++){
            if((position[i] - position[prev]) >= mid){
                count += 1;
                prev = i;
            }
        }

        return count;
    }
}