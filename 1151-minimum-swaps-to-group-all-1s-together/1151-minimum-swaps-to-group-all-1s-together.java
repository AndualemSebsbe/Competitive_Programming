class Solution {
    public int minSwaps(int[] data) {
        int n = data.length;
        int countOnes = 0;
        for(int d : data)
            if(d == 1)
                countOnes += 1;
        
        int zeros = 0;
        for(int i = 0; i < countOnes; i++)
            if(data[i] == 0)
                zeros += 1;
        
        int min = Integer.MAX_VALUE;
        min = Math.min(min, zeros);
        
        int l = 0, r = countOnes;
        while(r < n){
            if(data[r] == 0)
                zeros += 1;
            if(data[l] == 0)
                zeros -= 1;
            
            min = Math.min(min, zeros);
            l += 1; r += 1;
        }
        
        return min == Integer.MAX_VALUE ? zeros : min;
    }
}

/*
[1,0,1,0,1]
[0,0,0,1,0]
[1,0,1,0,1,0,0,1,1,0,1]
[1,1,1,1,1,1,1]
*/