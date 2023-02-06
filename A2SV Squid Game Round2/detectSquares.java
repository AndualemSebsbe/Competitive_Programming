import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DetectSquares {
    Map<String, Integer> map;
    List<int[]> list;
    public DetectSquares() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        map.put(key, map.getOrDefault(key, 0) + 1);
        list.add(point);
    }
    
    public int count(int[] point) {
        int res = 0;
        for(int[] p : list){
            int x = p[0];
            int y = p[1];
            int xDiff = Math.abs(point[0]-x), yDiff = Math.abs(point[1]-y);

            if((xDiff != yDiff) || x == point[0] || y == point[1])
                continue;

            String key1 = x + "," + point[1], 
            key2 = point[0] + "," + y;
            if(map.containsKey(key1) && map.containsKey(key2))
                res += map.get(key1) * map.get(key2);
            
        }

        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */