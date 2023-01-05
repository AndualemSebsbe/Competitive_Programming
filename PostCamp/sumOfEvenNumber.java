package PostCamp;

class sumOfEvenNumber {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int idx = 0, evenSum = 0;

        for(int num : nums)
            if(num % 2 == 0)
                evenSum += num;
        
        for(int[] q : queries){
            if(nums[q[1]] % 2 == 0)
                evenSum -= nums[q[1]];
            
            nums[q[1]] += q[0];
            if(nums[q[1]] % 2 == 0)
                evenSum += nums[q[1]];
            
            ans[idx++] = evenSum;
        }

        return ans;
    }
}