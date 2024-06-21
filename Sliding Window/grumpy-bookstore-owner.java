class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = grumpy.length;

        int l = 0, r = 0, numCustomers = 0;
        while(r < minutes){
            if(grumpy[r] == 1)
                numCustomers += customers[r];
            r += 1;
        }
        
        int maxCustomers = numCustomers;
        while(r < n){
            if(grumpy[r] == 1){
                numCustomers += customers[r];
                
            }
            if(grumpy[l] == 1)
                numCustomers -= customers[l];
            
            maxCustomers = Math.max(maxCustomers, numCustomers);
            l += 1;
            r += 1;
        }

        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0)
                maxCustomers += customers[i];
        }

        return maxCustomers;
    }
}