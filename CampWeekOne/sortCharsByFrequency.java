import java.util.HashMap;
import java.util.PriorityQueue;

class sortCharsByFrequency {
    public String frequencySort(String s) {
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      for(char c: s.toCharArray()){
          map.put(c, map.getOrDefault(c, 0) + 1);
      }
        
      PriorityQueue<Character> maxHeap = new PriorityQueue<Character>((a,b) -> map.get(b) -         map.get(a));
      maxHeap.addAll(map.keySet());
      StringBuilder result = new StringBuilder();
      while(!maxHeap.isEmpty()){
          char current = maxHeap.remove();
          for(int i=0; i < map.get(current); i++){
              result.append(current);
          }
      }
    return result.toString();
    }
}