import java.util.HashMap;
import java.util.Map;

public class minimumWindowSubstring {
    public String minWindow(String s, String t) {
        int l = 0, r = 0;
        
        Map<Character, Integer> mapT = new HashMap<>();
        for(char c : t.toCharArray())
            mapT.put(c, mapT.getOrDefault(c, 0)+1);
        
        int required = mapT.size();
        int formed = 0;
        int[] ans = {-1, 0, 0};
        Map<Character, Integer> mapS = new HashMap<>();
        
        while(r < s.length()){
            char c = s.charAt(r);
            mapS.put(c, mapS.getOrDefault(c, 0)+1);
            
            if(mapT.containsKey(c) && mapS.get(c).intValue() == mapT.get(c).intValue())
                formed++;
            while(l <= r && formed == required){
                c = s.charAt(l);
                if(ans[0] == -1 || ans[0] > r+1-l){
                    ans[0] = r+1-l;
                    ans[1] = l;
                    ans[2] = r;
                }
                
                mapS.put(c, mapS.get(c)-1);
                if(mapT.containsKey(c) && mapS.get(c).intValue() < mapT.get(c).intValue())
                    formed--;
                l++;
            }
            r++;
        }
        return ans[0] != -1 ? s.substring(ans[1], ans[2]+1) : "";
    }
}