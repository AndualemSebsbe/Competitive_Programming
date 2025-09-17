import java.util.Arrays;

class minimumPairSum {
    public int minPairSum(int[] nums) {
      int len = nums.length;
      Arrays.sort(nums);
        int l=0;// the first index of the array
        int r=len-1;// the last index of the array
        int max=0, sumOfPair=0;
      for(int i=0; i<len/2; i++){
          sumOfPair = nums[l++] + nums[r--];
          max = Math.max(sumOfPair,max);
      }
       
      return max;
    }
}
