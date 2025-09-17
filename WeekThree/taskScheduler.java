import java.util.HashMap;
import java.util.Map;

public class taskScheduler {
    
        public int leastInterval(char[] tasks, int n) {
            int len = tasks.length;
            int maxFreq = 0;
            if(n == 0)
                return len;
           HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for(char ch: tasks){
                int occ = map.getOrDefault(ch, 0) + 1;
                map.put(ch, occ);
                maxFreq = Math.max(maxFreq, occ);           
            }
            //let the number of maxFreq we have Initially
            int count = 0;
            for (Map.Entry<Character, Integer> entry: map.entrySet()) {
                 if(entry.getValue() == maxFreq)
                  count++;
          }
            // number of unique task and cooldown(idle)
            int numEachGp = n + 1;
            // number of group
            int numGp = maxFreq - 1;
            int rem = len -(numEachGp*numGp + count);
            int res = 0;
            if(rem >0)
                res = numEachGp*numGp + count + rem;
            else
                res = numEachGp*numGp + count;
            return res;
        }
    }
