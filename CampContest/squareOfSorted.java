import java.util.Arrays;

class squareOfSorted {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        for(int num : nums){
            nums[i++] = num * num;
        }
        
        Arrays.sort(nums);
        return nums;
    }
}