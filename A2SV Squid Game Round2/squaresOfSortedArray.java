class squaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] count = new int[10001];

        for(int num : nums){
            if(num < 0)
                count[-1*num] += 1;
            else
                count[num] += 1;
        }

        int idx = 0;
        for(int i = 0; i < count.length; i++){
            while(count[i]-- > 0)
                nums[idx++] = i;
        }

        for(int i = 0; i < nums.length; i++)
            nums[i] *= nums[i];

        return nums;
    }
}