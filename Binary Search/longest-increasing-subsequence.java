class Solution {
    public int lengthOfLIS(int[] nums) {
        //using Binary Search TC - O(nlogn)
        int n = nums.length;
        List<Integer> list = new ArrayList();
        list.add(nums[0]);
    
        for(int i = 1; i < n; i++){
            if(list.get(list.size()-1) < nums[i])
                list.add(nums[i]);
            else
                 binarySearch(list, nums[i]);
        }
        
        return list.size();
    }
    
    public void binarySearch(List<Integer> list, int target){
        int l = 0, r = list.size()-1; 
        int index = 0;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(target == list.get(mid)){
                index = mid;
                break;
            }
            
            if(list.get(mid) < target){
                l = mid+1;
            }
            else{
                r = mid-1;
                index = mid;
            }
        }
        list.set(index, target);
    }
}