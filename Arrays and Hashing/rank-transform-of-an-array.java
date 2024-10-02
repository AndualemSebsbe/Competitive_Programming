class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> tSet = new TreeSet();
        for (int num : arr)
            tSet.add(num);
        
        Map<Integer, Integer> ranks = new HashMap();
        int rank = 1;
        for (int key : tSet) {
            ranks.put(key, rank);
            rank += 1;
        }

        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            rank = ranks.get(arr[i]);
            res[i] = rank; 
        }

        return res;
    }
}