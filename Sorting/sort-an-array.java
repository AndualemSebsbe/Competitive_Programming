class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        return nums;
    }

    void mergeSort(int[] nums, int l, int r){
        if(l == r)
            return;
        
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    void merge(int[] nums, int l, int mid, int r){
        int[] left = new int[mid - l + 1];
        for(int i = 0; i < left.length; i++)
            left[i] = nums[l + i];

        int[] right = new int[r - mid];
        for(int i = 0; i < right.length; i++)
            right[i] = nums[mid + 1 + i];
        
        int i = 0, j = 0, k = l;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                nums[k] = left[i];
                i += 1;
            }
            else {
                nums[k] = right[j];
                j += 1;
            }

            k += 1;
        }

        while(i < left.length)
            nums[k++] = left[i++];
        
        while(j < right.length)
            nums[k++] = right[j++];
    }
}