package PostCamp;

import java.util.HashMap;
import java.util.Map;

class minRound {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int task : tasks)
            map.put(task, map.getOrDefault(task, 0) + 1);
        
        int res = 0;
        for(int key : map.keySet()){
            int val = map.get(key);

            if(val == 1)
                return -1;
            
            if(val % 3 == 0)
                res += (val/3);
            else
                res += (val/3 + 1);
        }

        return res;
    }
}