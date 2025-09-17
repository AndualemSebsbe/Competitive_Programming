class Solution {
    public int countTriplets(int[] arr) {
        int count = 0, n = arr.length;
        for(int i = 0; i < n; i++){
            int xora = 0;
            for(int j = i + 1; j < n; j++){
                xora ^= arr[j - 1];
                
                int xorb = 0;
                for(int k = j; k < n; k++){
                    xorb ^= arr[k];

                    if(xora == xorb)
                        count += 1;
                }
            }
        }

        return count;
    }
}