class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap();
        for (int[] arr : nums1) {
            int key = arr[0];
            if (map.containsKey(key)) {
                int val = map.get(key);
                map.put(key, val + arr[1]);
            }
            else
                map.put(key, arr[1]);
        }

        for (int[] arr : nums2) {
            int key = arr[0];
            if (map.containsKey(key)) {
                int val = map.get(key);
                map.put(key, val + arr[1]);
            }
            else
                map.put(key, arr[1]);
        }

        int[][] res = new int[map.size()][2];
        int idx = 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            res[idx][0] = key;
            res[idx++][1] = val;
        }

        return res;
    }
}