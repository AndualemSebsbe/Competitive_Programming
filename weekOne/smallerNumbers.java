class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int count=0;
        int len=nums.length;
        int[] counter=new int[len];
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if((j!=i) && (nums[j] < nums[i])){
                    ++count;
                }
            }
            counter[i]=count;
            count=0;
        }
        return counter;
    }
}