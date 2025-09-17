import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestPalindromeByConcatenating {

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        int count = 0;
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        for(String key : map.keySet()){
            String rev = String.valueOf(key.charAt(1)) + String.valueOf(key.charAt(0));
            if(rev.equals(key) && map.get(key) % 2 == 1){
                count += 2;
                break;
            }               
        }
        
        for(String key : map.keySet()){
            if(!visited.contains(key)){
            String rev = String.valueOf(key.charAt(1)) + String.valueOf(key.charAt(0));
            
            if(map.containsKey(rev)){
                if(!rev.equals(key)){
                    visited.add(rev);
                    int min = Math.min(map.get(key), map.get(rev));
                    count += (min * 4);
                }
                else if(rev.equals(key) && map.get(key) > 1){
                    int val = map.get(key)/2 * 2;
                    count += (val*2);
                }
            }
            }
        }
        
        return count;
    }
}