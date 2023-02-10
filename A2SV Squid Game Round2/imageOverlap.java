class imageOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int overlap = 0;
        int n = img1.length;
        for(int i = -n; i < n; i++) {
            for(int j = -n; j < n; j++) {
                overlap = Math.max(overlap, overlap(img1, img2, i, j));
            }
        }

        return overlap;
    }

    int overlap(int[][] img1, int[][] img2, int row, int col) {
        int total = 0;
        int n = img1.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i+row < 0 || i+row >= n || j+col < 0 || j+col >= n)
                    continue;
                
                if(img1[i+row][j+col] == 1 && img2[i][j] == 1) 
                    total++;
            }
        }

        return total;
    }
}