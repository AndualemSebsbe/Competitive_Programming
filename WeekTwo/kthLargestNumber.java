
import java.util.Arrays;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
       
        int len = nums.length;
        
        // Refer below post for understanding below expression:
        // https://www.geeksforgeeks.org/lambda-expressions-java-8/
        Arrays.sort(nums, (left, right) ->
        {
            /* If length of left != right, then return
               the diff of the length else  use compareTo
               function to compare values.*/
            if (left.length() != right.length())
                return left.length() - right.length();
             return left.compareTo(right);
        });
        int kLargest=len-k;
      return nums[kLargest];  
    }
}