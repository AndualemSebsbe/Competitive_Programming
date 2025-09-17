import java.util.HashSet;
import java.util.Set;

public class uniqueMorseCode {

    public int uniqueMorseRepresentations(String[] words) {
        String[] str = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String s = "abcdefghijklmnopqrstuvwxyz";

        Set<String> set = new HashSet<>();
        
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < word.length(); j++){
                for(int i=0; i < 26; i++){
                    if(word.charAt(j) == s.charAt(i))   
                    sb.append(str[i]);
            }
            }
            
            set.add(sb.toString());
        }
    
        return set.size();
    }
}