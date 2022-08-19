class capacityToShip {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, maxWeight = 0;
        for(int weight : weights){
            if(weight > maxWeight)
                maxWeight = weight;
            sum += weight;
        }
        // int l = Arrays.stream(weights).max().getAsInt();
        int l = maxWeight;
        int r = sum;
        
        while(l < r){
            int mid = l + (r-l)/2;
            
            if(!canShip(weights, mid, days)){
            r = mid;
          }
        else{
               l = mid + 1;
            }
        }
        return l;
    }
    
    public boolean canShip(int[] weights, int mid, int days){
        int sum = 0, day = 1;
        for(int weight : weights){
            sum += weight;
            if(sum > mid){
                day += 1;
                sum = weight;
            }
        }
        
        return day > days;
    }
}