import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinationOfPhoneNo {

    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        
        List<String> prefixes = new ArrayList<>();
        for(int i = 0; i < digits.length(); i++){
            int digit = digits.charAt(i) - '0';
            if(prefixes.isEmpty())
            prefixes.add("");
        
            List<String> newPrefixes = new ArrayList<>();
            for(String prefix : prefixes){
                for(char letter : map.get(digit).toCharArray()){
                        newPrefixes.add(prefix + letter);
                }
            }
            prefixes = newPrefixes;
        }
        return prefixes;
    }
}