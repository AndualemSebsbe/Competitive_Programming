import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int len=nums.length;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<len; i++){
            for(int j=0; j<len-1; j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }                
            }
        }

        for(int i=0; i< len; i++){
            if(nums[i]==target){
                arr.add(i);
            }
          
        }
        
        
        return arr;
    }
}