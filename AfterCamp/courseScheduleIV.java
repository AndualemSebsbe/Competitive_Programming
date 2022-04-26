class courseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        boolean [][] grid = new  boolean [numCourses][numCourses];
        // System.out.println(grid[0][0]);
        List<Integer>[] g = new List[numCourses]; // we can also use Map<Integer, List<integer>>
     
        for(int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<>();
        }
        
         for(int[] pp : prerequisites) {
            g[pp[0]].add(pp[1]);
        } 
        // System.out.println(Arrays.toString(g));
        
        for(int i = 0; i < numCourses; i++){
            bfs(g, grid, i);
        }
        
        List<Boolean> ans = new ArrayList<>();
        
        for(int[] q : queries){
            ans.add(grid[q[0]][q[1]]);
        }
        return ans;
    }
    
    public void bfs(List<Integer>[] g, boolean[][] grid, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while(queue.size() > 0){
            int curr = queue.poll();
            if(!grid[start][curr]){
                grid[start][curr] = true;
                for(int next : g[curr]){
                    queue.add(next);
                }
            }
        }
        
    }
}