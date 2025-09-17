class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int[] counting = new int[1001];
        for(int i = 0; i < n; i++){
            counting[arr1[i]] += 1;
        }

        int[] res = new int[n];
        int idx = 0;
        for(int num : arr2){
            while(counting[num]-- > 0)
                res[idx++] = num;
        }

        for(int i = 0; i < counting.length; i++){
            while(counting[i]-- > 0)
                res[idx++] = i;
        }

        return res;
    }
}