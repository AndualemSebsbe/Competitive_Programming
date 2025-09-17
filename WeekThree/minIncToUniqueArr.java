import java.util.Arrays;

class minIncToUniqueArr {
    public int minIncrementForUnique(int[] nums) {
        int len = nums.length;
        int count=0;
        // sort the array
        Arrays.sort(nums);
        for(int i=0; i<len-1; i++){
            if(nums[i+1] <= nums[i]){
                count = count + (nums[i] - nums[i+1]) + 1;
                nums[i+1] += (nums[i] - nums[i+1])  + 1;
                
            }
        }
       return count; 
    }
}