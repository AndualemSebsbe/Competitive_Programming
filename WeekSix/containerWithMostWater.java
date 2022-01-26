class containerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        int maxValue = 0;
        int minValue = 0;
        int l=0, r = len - 1;
        
        while(l < r){
            
           minValue = Math.min(height[l], height[r]);
           maxValue = Math.max(maxValue, minValue * (r-l));
            if(minValue == height[l])
                l++;
            if(minValue == height[r])
                r--;
        }
        return maxValue;
    }
}