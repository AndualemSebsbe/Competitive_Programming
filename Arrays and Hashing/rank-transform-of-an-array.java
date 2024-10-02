class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> tMap = new TreeMap();
        for (int i = 0; i < n; i++) {
            if (!tMap.containsKey(arr[i]))
                tMap.put(arr[i], new ArrayList());
            tMap.get(arr[i]).add(i);
        }
        
        int rank = 1;
        for (int key : tMap.keySet()) {
            List<Integer> indexes = tMap.get(key);
            for (int idx : indexes) {
                arr[idx] = rank;
            }

            rank += 1;
        }

        return arr;
    }
}