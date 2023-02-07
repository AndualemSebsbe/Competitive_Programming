class robotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int dir[][] = {{0,1}, {-1, 0}, {0, -1}, {1,0}};
        int idx = 0;
        int x = 0;
        int y = 0;
       
        for(int s = 0; s < instructions.length(); s++){
            if(instructions.charAt(s) == 'L'){
                idx = (idx + 1) % 4;
            }
            else if(instructions.charAt(s) == 'R'){
                idx = (idx + 3) % 4;
            }
            else{
                x = x + dir[idx][0];
                y = y + dir[idx][1];
            }
        }
        return x == 0 && y == 0 || idx != 0;
    }
}