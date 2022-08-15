class predictWinner {
    
    public boolean PredictTheWinner(int[] nums) {
        int s = 0;
        int e = nums.length-1;
      
        int p1 = winner(nums, s, e, 1);
        
        return p1 >= 0;
    }
     
    public int winner(int[] nums, int s, int e, int turn){
        
        if(s == e) return turn*nums[s];
        
        int first = turn*nums[s] + winner(nums, s+1, e, -turn);
        int last = turn*nums[e] + winner(nums, s, e-1, -turn);
        
        
        return turn*Math.max(turn*first, turn*last);
    }
}


