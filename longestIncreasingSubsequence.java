import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class longestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    //get actual subsequence
    public List<Integer> getSubsequence(int[] nums) {
        int n = nums.length;
        //dp[i] = length of longest increasing subsequence ending at index i
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); 
                }
            }
        }

        int max = Arrays.stream(dp).max().getAsInt();
        List<Integer> subsequence = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == max) {
                subsequence.add(nums[i]);
                max--;
            }
        }
        Collections.reverse(subsequence);
        return subsequence;
    }

    //main method
    public static void main(String[] args) {
        longestIncreasingSubsequence lis = new longestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lis.lengthOfLIS(nums));
        System.out.println(lis.getSubsequence(nums));
    }
}