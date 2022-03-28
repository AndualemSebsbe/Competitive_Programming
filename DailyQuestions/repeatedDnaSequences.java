import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class repeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        while((i + 10) <= s.length()){
          String subsequence = s.substring(i, i + 10);
          map.put(subsequence, map.getOrDefault(subsequence, 0) + 1);
          if(map.get(subsequence) == 2)
              list.add(subsequence);
            i++;
        }
        return list;
    }
}