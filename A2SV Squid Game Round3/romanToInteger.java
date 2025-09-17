import java.util.HashMap;
import java.util.Map;

class romanToInteger {
    public int romanToInt(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int res = map.get(s.charAt(n-1));
        
        for(int i = n-2; i >= 0; i--){
            char c1 = s.charAt(i);
            char c2 = s.charAt(i+1);
            
            if(map.get(c1) < map.get(c2))
                res -= map.get(c1);
            else
                res += map.get(c1);
        }
        
        return res;
    }
}