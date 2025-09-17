import java.util.HashSet;
import java.util.Set;

class numOfProvince {
    int count = 0;
    Set<Integer> visited = new HashSet<Integer>();
    public int findCircleNum(int[][] isConnected) {
        for(int i = 0; i < isConnected.length; i++){
            if (!visited.contains(i)){
                count ++;
                dfs(isConnected, i);
            }
        }           
        return count;
    }
    
    public void dfs(int[][] isConnected, int i){
        visited.add(i);
        for(int j = 0; j < isConnected.length; j++){
            if (isConnected[i][j] == 1 && !visited.contains(j)){
                dfs(isConnected,  j);
            }
        }
        
    }
}