import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Allone {

    // Map that stores key to the node
    Map<String, Integer> map;
    
    // Map that groups keys having same value using double
    // linked list as value
    Map<Integer, Set<String>> valueMap;
    
    // MinMax linkedlist to keep track of
    // min and max values
    LinkedList<Integer> minMax;

    /** Initialize your data structure here. */
    public AllOne() {
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
            // Remove from value map for old value
            removeFromValueMap(val, key);
            
            map.put(key, val + 1);
            // Place it the new value in value map
            putInValueMap(val + 1, key);
        }
    }
  
    public void dec(String key) {
        // If this key not found, just return
        if(!map.containsKey(key)) {
            return;
        }
        
        int val = map.get(key);
        // If value is 1, then remove from map
        if(val == 1) {
            map.remove(key);
            // Remove from value map too
            removeFromValueMap(1, key);
        } else {
            // Remove from old value
            removeFromValueMap(val, key);
            // Decrement value
            map.put(key, val - 1);
            
            // Insert at new value
            putInValueMap(val - 1, key);
        }
        
    }
    
    public String getMaxKey() {
        if(minMax.isEmpty()) {
            return "";
        }
        // minMax.getFirst() always has max value
        return valueMap.get(minMax.getFirst()).iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(minMax.isEmpty()) {
            return "";
        }
        // minMax.getFirst() always has min value
        return valueMap.get(minMax.getLast()).iterator().next();
    }
    
    private void putInValueMap(int count, String node) {
        // If not seen before, create a new dll
        if(!valueMap.containsKey(count)) {
            valueMap.put(count, new HashSet<String>());
        }
        // Add to dll
        valueMap.get(count).add(node);
        
        // Update min max
        if(minMax.isEmpty() || minMax.getFirst() < count) {
            minMax.addFirst(count);
        }
        
        if(!minMax.isEmpty() && minMax.getLast() > count) {
            minMax.addLast(count);
        }
    }
    
    private void removeFromValueMap(int count, String node) {
        // If not present in value map, just return
        if(!valueMap.containsKey(count)) {
            return;
        }
        
        // Remove from dll in value map
        valueMap.get(count).remove(node);
        
        // If no elements present with this value
        if(valueMap.get(count).size() == 0) {
            // Remove from value map all together
            valueMap.remove(count);
            
            // Update min max
            if(!minMax.isEmpty() && minMax.getFirst() == count) {
                minMax.removeFirst();
            }
            if(!minMax.isEmpty() && minMax.getLast() == count) {
                minMax.removeLast();
            }
        }
    }
}