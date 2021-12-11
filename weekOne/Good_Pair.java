class Solution {
    public int numIdenticalPairs(int[] nums) {
        
        int count=0;
        int num=nums.length;
        if(num>=1 && num<=100){
        for(int i=0; i< num; i++){
            for(int j=1; j<num;j++){
                if(nums[i]>=1 && nums[i]<=100){
              if(nums[i]==nums[j] && i < j){
                 count++;     
              }
            }
            }
        }
        }
        return count;
    }
}