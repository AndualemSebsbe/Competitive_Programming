import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class isomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap();
        Set<Character> set = new HashSet();
        
        for(int i = 0; i < s.length(); i++){
            char ch = map.getOrDefault(s.charAt(i), '0');
            
            if(ch == '0' && !set.contains(t.charAt(i))){
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
            else if(ch == t.charAt(i))
                continue;
            else
                return false;
        }
        return true;
    }
}