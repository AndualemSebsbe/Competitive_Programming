class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n-1] - nums[0];
        int best = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(isPossible(nums, mid) >= p){
                best = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        return best;
    }

    int isPossible(int[] nums, int mid){
        int pairs = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i+1] - nums[i] <= mid){
                pairs += 1;
                i += 1;
            }
        }

        return pairs;
    }
}