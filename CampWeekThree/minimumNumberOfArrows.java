import java.util.Arrays;

class minimumNumberOfArrows {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        int count = 0;
        if(len == 1) return 1;
        // Arrays.sort(points, (a, b) -> a[1] - b[1]);
        // Sorting on the basis of end points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1])); 
     
        for(int i = 0; i < len - 1; i++){
            if(points[i][1] >= points[i+1][0]){
                int j = i;
                while((i < len - 1) && (points[j][1] >= points[i+1][0]))
                    i++;
                count++; 
            }
            else{
                count++;
            }
            if(i + 1 == len - 1)
                count++;
        }
        return count;
    }
}