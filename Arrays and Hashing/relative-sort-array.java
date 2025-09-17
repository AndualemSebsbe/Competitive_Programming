class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        Map<Integer, List<Integer>> map = new HashMap();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(arr1[i]))
                map.put(arr1[i], new ArrayList());
            map.get(arr1[i]).add(i);
        }

        int[] res = new int[n];
        int idx = 0;
        Set<Integer> set = new HashSet();
        for(int num : arr2){
            for(int i : map.get(num))
                res[idx++] = arr1[i];
            set.add(num);
        }

        int i = idx;
        for(int num : arr1){
            if(!set.contains(num))
                res[idx++] = num;
        }

        Arrays.sort(res, i, n);

        return res;
    }
}