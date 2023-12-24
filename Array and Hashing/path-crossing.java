class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet();
        int[] dir = {0, 0};
        visited.add(dir[0] + "#" + dir[1]);
        for(char c : path.toCharArray()){
            if(c == 'N')
                dir[1] += 1;
            else if(c == 'E')
                dir[0] += 1;
            else if(c == 'S')
                dir[1] -= 1;
            else if(c == 'W')
                dir[0] -= 1;
            
            String str = dir[0] + "#" + dir[1];
            if(visited.contains(str))
                return true;
            
            visited.add(str);
        }

        return false;
    }
}