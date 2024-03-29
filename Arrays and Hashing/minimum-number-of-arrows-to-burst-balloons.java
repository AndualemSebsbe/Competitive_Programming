class Solution {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
            
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0])); 
        
        int count = 0;
        int minEnd = points[0][1];
        for(int i = 0; i < len; i++){
            if(i == 0 || points[i][0] > minEnd){
                minEnd = points[i][1];
                count += 1; 
            }
            else
                minEnd = Math.min(minEnd, points[i][1]);
        }

        return count;
    }
}