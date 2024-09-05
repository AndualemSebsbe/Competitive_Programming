class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int n = obstacles.length;
        HashSet<String> set = new HashSet();
        for (int i = 0; i < n; i++) 
            set.add(obstacles[i][0] + " " + obstacles[i][1]);
        
        int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int[] coord = {0, 0};
        int res = 0, curDir = 0;
        for (int command : commands) {
            if (command == -1)
                curDir += 1;
            else if (command == -2)
                curDir -= 1;
            else {
                while (command-- > 0) {
                    coord[0] += dirs[curDir][0]; 
                    coord[1] += dirs[curDir][1];
                    if (set.contains(coord[0] + " " + coord[1])) {
                        coord[0] -= dirs[curDir][0];
                        coord[1] -= dirs[curDir][1];
                        break;
                    }
                }
                
                res = Math.max(res, coord[0] * coord[0] + coord[1] * coord[1]);
            }
            
            if (curDir < 0)
                curDir += 4;
            curDir = curDir % 4;
        }

        return res;
    }
}