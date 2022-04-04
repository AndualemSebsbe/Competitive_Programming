class checkIfArrIsSorted {
    public boolean check(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        //
        int minIndex = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[minIndex]){
                minIndex = i;
            }
            else if(nums[i] == nums[minIndex]){
                int temp = minIndex;
                if((nums[i] == nums[minIndex]) && (i - 1 == temp)){
                    while((i < nums.length) && (nums[i] == nums[minIndex]) && (i - 1 == temp)){
                        temp++; i++;
                    } 
                    i--;
                }
                else
                    minIndex = i;
            }
           
        }
        
        if(minIndex == 0){
            for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        }
        else{
            int[] nums2 = new int[nums.length];
            int temp = minIndex, i = 0;
            nums2[i++] = nums[temp];
            while(++temp % nums.length != minIndex){
                nums2[i++] = nums[temp % nums.length];
            }
            
            //now check if it is sorted
            for (i = 0; i < nums.length - 1; i++) {
            if (nums2[i] > nums2[i + 1]) {
                return false;
            }
        }
        }
 
        return true; 
    }
}
//Testcases
// [3,4,5,1,2]
// [2,1,3,4]
// [1,2,3]
// [7,9,1,1,1,3]
// [6,10,6]
// [10,6,6]