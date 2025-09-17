import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class partitionTwoArrays {
    Map<Integer, TreeSet<Integer>> leftMap = new HashMap<>();
    Map<Integer, TreeSet<Integer>> rightMap = new HashMap<>();

    public int minimumDifference(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        int n = nums.length;
        subsets(0, Arrays.copyOfRange(nums, 0, n / 2), 0, 0, leftMap);
        subsets(0, Arrays.copyOfRange(nums, n / 2, n), 0, 0, rightMap);
        int ans = Integer.MAX_VALUE;
        for (int len : leftMap.keySet()) {
            int rightArrayLen = nums.length / 2 - len;
            TreeSet<Integer> right = rightMap.get(rightArrayLen);
            if (right != null) {
                for (int leftSum : leftMap.get(len)) {
                    int rightSum = sum / 2 - leftSum;
                    Integer closest = right.floor(rightSum);
                    if (closest != null) {
                        int oneSum = (closest + leftSum);
                        int otherSum = sum - oneSum;
                        ans = Math.min(ans, Math.abs(oneSum - otherSum));
                    }
                }
            }
        }
        return ans;
    }

    void subsets(int idx, int[] arr, int sum, int len, Map<Integer, TreeSet<Integer>> map) {
        if (idx >= arr.length) {
            TreeSet<Integer> set = map.getOrDefault(len, new TreeSet<>());
            set.add(sum);
            map.put(len, set);
            return;
        }
        subsets(idx + 1, arr, sum, len, map);
        subsets(idx + 1, arr, sum + arr[idx], len + 1, map);
    }
}