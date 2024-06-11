class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet();
        int n = arr1.length;
        int[] res = new int[n];
        int idx = 0;
        for(int num : arr2){
            for(int i = 0; i < n; i++){
                if(arr1[i] == num)
                    res[idx++] = num;
            }
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