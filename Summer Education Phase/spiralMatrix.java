import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        double rotation = Math.ceil(row/2);
        boolean[][] visited = new boolean[row][col];
        List<Integer> list = new ArrayList();
        
        for(int i = 0; i <= (int)rotation; i++){
            for(int j=i; j < col; j++){
                if(!visited[i][j])
                list.add(matrix[i][j]);
                visited[i][j] = true;
            }
            for(int r = i; col-1 >= 0 && r < row; r++){
                if(!visited[r][col-1])
                list.add(matrix[r][col-1]);
                visited[r][col-1] = true;
            }
            for(int j = col-1; row-1 >= 0 && j >= i; j--){
                if(!visited[row-1][j])
                list.add(matrix[row-1][j]);
                visited[row-1][j] = true;
            }
            for(int r = row-1; i < col && r > i; r--){
                if(!visited[r][i])
                list.add(matrix[r][i]);
                visited[r][i] = true;
            }
            row--; col--;
        }
        
        return list;
    }
}