import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class stampingTheSequences {

    public int[] movesToStamp(String stamp, String target) {
        int indx = target.length() - stamp.length();
        
        int count = 0;
        char[] tChar = target.toCharArray();
        char[] sChar = stamp.toCharArray();
        Set<Integer> visited = new HashSet();
        List<Integer> res = new ArrayList();
        
        while(count != tChar.length){
            boolean didChanged = false;
            for(int i = 0; i <= indx; i++){
                if(!visited.contains(i) && canReplace(tChar, sChar, i)){
                    count = replace(tChar, sChar.length, i, count);
                    visited.add(i);
                    didChanged = true;
                    res.add(i);
                    
                    if(count == tChar.length)
                        break;
                }
            }
            
            if(!didChanged){
                return new int[0];
            }
        }
        
        int[] result = new int[res.size()];
        int j = 0;
        for(int i = res.size()-1; i >= 0; i--)
            result[j++] = res.get(i);
        return result;
    }
    
    public boolean canReplace(char[] tChar, char[] sChar, int start){
        for(int i = 0; i < sChar.length; i++){
            if(tChar[i+start] != '?' && tChar[i+start] != sChar[i])
                return false;
        }
        return true;
    }
    
    public int replace(char[] tChar, int len, int start, int count){
        for(int i = start; i < (start + len); i++){
            if(tChar[i] != '?'){
                tChar[i] = '?';
                count++;
            }
        }
        
        return count;
    }
}