class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int len = rows * cols;
        int[][] res = new int[len][2];

        int r = rStart, c = cStart;
        int idx = 0, dir = 0;
        int steps = 1;
        while (idx < len) {
            for (int i = 0; i < 2; i++) {
                int dr = dirs[dir][0], dc = dirs[dir][1];
                for (int step = 0; step < steps; step++) {
                    if(r >= 0 && r < rows && c >= 0 && c < cols){
                        res[idx][0] = r;
                        res[idx++][1] = c;
                    }

                    r += dr;
                    c += dc;
                }

                dir = (dir + 1) % 4;
            } 

            steps += 1;
        }

        return res;
    }
}