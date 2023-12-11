class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = 0;
        for(int house : houses){
            radius = Math.max(radius, closestRadius(house, heaters));
        }

        return radius;
    }

    int closestRadius(int house, int[] heaters){
        int minDist = Integer.MAX_VALUE;
        int l = 0, r = heaters.length-1;

        while(l <= r){
            int mid = l + (r-l)/2;
            minDist = Math.min(minDist, Math.abs(heaters[mid] - house));

            if(heaters[mid] < house)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return minDist;
    }
}