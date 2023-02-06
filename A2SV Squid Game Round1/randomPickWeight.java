import java.util.Random;
import java.util.TreeMap;

class randomPickWeight {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Random rand = new Random();
    int count = 0;
    
    public randomPickWeight(int[] w) {
        int n = w.length;
        for(int i = 0; i < n; i++){
            count += w[i];
            map.put(count, i);
        } 
    }
    
    public int pickIndex() {
        int key = map.higherKey(rand.nextInt(count));

        return map.get(key);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */