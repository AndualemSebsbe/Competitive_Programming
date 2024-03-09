class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int i = 0, j = 0;
        while(j < len2 && i < len1){
            if(nums1[i] == nums2[j])
                return nums1[i];
            else if(nums1[i] < nums2[j])
                i += 1;
            else if(nums2[j] < nums1[i])
                j += 1;
        }

        return -1;
    }
}