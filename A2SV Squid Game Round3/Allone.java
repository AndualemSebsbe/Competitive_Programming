import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class allOne {

    Map<String, Integer> map;
    Map<Integer, Set<String>> valueMap;
    LinkedList<Integer> minMax;

    public allOne() {
        map = new HashMap<>();
        valueMap = new HashMap<>();
        minMax = new LinkedList<Integer>();
    }
    
    public void inc(String key) {
        if(!map.containsKey(key)) {
            map.put(key, 1);
            putInValueMap(1, key);
        } else {
            
            int val = map.get(key);
            removeFromValueMap(val, key);
            
            map.put(key, val + 1);
            putInValueMap(val + 1, key);
        }
    }
  
    public void dec(String key) {
        if(!map.containsKey(key)) {
            return;
        }
        
        int val = map.get(key);
        if(val == 1) {
            map.remove(key);
            removeFromValueMap(1, key);
        } else {
            removeFromValueMap(val, key);
            map.put(key, val - 1);
            
            putInValueMap(val - 1, key);
        }
        
    }
    
    public String getMaxKey() {
        if(minMax.isEmpty()) {
            return "";
        }

        return valueMap.get(minMax.getFirst()).iterator().next();
    }
    
    public String getMinKey() {
        if(minMax.isEmpty()) 
            return "";
        
        return valueMap.get(minMax.getLast()).iterator().next();
    }
    
    private void putInValueMap(int count, String node) {
        if(!valueMap.containsKey(count)) 
            valueMap.put(count, new HashSet<>());
        
        valueMap.get(count).add(node);
        
        if(minMax.isEmpty() || minMax.getFirst() < count) {
            minMax.addFirst(count);
        }
        
        if(!minMax.isEmpty() && minMax.getLast() > count) {
            minMax.addLast(count);
        }
    }
    
    private void removeFromValueMap(int count, String node) {
        if(!valueMap.containsKey(count)) {
            return;
        }
        
        valueMap.get(count).remove(node);
        
        if(valueMap.get(count).size() == 0) {
            valueMap.remove(count);
            
            if(!minMax.isEmpty() && minMax.getFirst() == count) {
                minMax.removeFirst();
            }
            if(!minMax.isEmpty() && minMax.getLast() == count) {
                minMax.removeLast();
            }
        }
    }
}