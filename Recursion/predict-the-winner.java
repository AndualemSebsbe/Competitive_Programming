class Solution {    
    public boolean predictTheWinner(int[] nums) {
        int s = 0;
        int e = nums.length-1;
      
        int p1 = winner(nums, s, e);
        return p1 >= 0;
    }
     
    public int winner(int[] nums, int s, int e){
        if(s == e) 
            return nums[s];
        
        int first = nums[s] - winner(nums, s + 1, e);
        int last = nums[e] - winner(nums, s, e - 1);
        
        return Math.max(first, last);
    }
}

