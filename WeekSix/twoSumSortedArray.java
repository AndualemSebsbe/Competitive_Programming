class twoSumSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        int indx1 = 0, indx2 = len-1;
        int[] indxArray = new int[2];
        while(indx1 < indx2){
            if(numbers[indx1] + numbers[indx2] == target)
            {
                indxArray[0] = indx1 + 1;
                indxArray[1] = indx2 + 1;
                return indxArray;
            }
            else{
                if(numbers[indx1] + numbers[indx2] < target)
                    indx1++;
                else
                    indx2--;
                }
            }
 
         return indxArray;
    }
}