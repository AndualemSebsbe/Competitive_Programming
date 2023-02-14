class findNUniqueIntegers {
    public int[] sumZero(int n) {
        int[] nums = new int[n];
       
        if(n % 2 == 0){
            int idx = 0;
            for(int i = 1; i <= n; i++){
                if(i % 2 != 0)
                    nums[idx++] = -1*i;
                else
                    nums[idx++] = i-1;
            }
        }
        else{
            nums[0] = 0;
            for(int i = 1; i < n; i++){
                if(i % 2 != 0)
                    nums[i] = -1*i;
                else
                    nums[i] = i-1;
            }
        }

        return nums;
    }
}