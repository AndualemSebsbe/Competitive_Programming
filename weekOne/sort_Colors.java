class sort_Colors {
    public void sortColors(int[] nums) {
        int len=nums.length;
        // create buckets
        int counter[] = new int[3]; 
        // fill buckets 
        for (int i : nums)
        { 
            counter[i]++; 
        }
        // sort array 
        int ndx = 0; 
        for (int i = 0; i < counter.length; i++) 
        {
            while (0 < counter[i])
            { 
                nums[ndx++] = i; 
                counter[i]--;
            }
        }
         
         for(int i=0; i< len; i++){
             System.out.print(nums[i]);
         }
    }
}