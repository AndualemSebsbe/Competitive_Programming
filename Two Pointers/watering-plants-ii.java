class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;

        if(n == 1)
            return 0;

        int totalFills = 0;
        int aliceCan = capacityA, bobCan = capacityB;

        int i = 0, j = n - 1;
        while(i <= j){
            if(i == j){
                if(aliceCan >= bobCan){
                   if(aliceCan < plants[i])
                        totalFills += 1; 
                    i += 1;
                }
                else{
                    if(bobCan < plants[j])
                        totalFills += 1;
                    j -= 1;
                }
            }
            else {
                if(aliceCan < plants[i]){
                    aliceCan = capacityA;
                    totalFills += 1;
                }
                aliceCan -= plants[i];
                i += 1;

                if(bobCan < plants[j]){
                    bobCan = capacityB;
                    totalFills += 1;
                }
                bobCan -= plants[j];
                j -= 1;
            }
        }

        return totalFills;
    }
}