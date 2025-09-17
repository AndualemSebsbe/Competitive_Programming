package AfterCamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// tourist
// petr
// wjmzbmr
// yeputons
// vepifanov
// scottwu
// oooooooooooooooo
// subscriber
// rowdark
// tankengineer
public class foxName {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("rivest");
        words.add("shamir");
        words.add("adleman");
    
        int n = words.size();
        Map<Character, List<Character>> map = new HashMap<>(); 
        int[] inDegree = new int[26];

        for(int i = 0; i < n - 1;i++){
            String currentWord = words.get(i);
            String nextWord = words.get(i + 1);

            int minlen = Math.min(currentWord.length(),nextWord.length());
            for(int j = 0;j < minlen;j++){
                char firstLetter = currentWord.charAt(j);
                char secondLetter = nextWord.charAt(j);
                if(firstLetter != secondLetter){
                    map.computeIfAbsent(firstLetter, l -> new ArrayList<>()).add(secondLetter);
                    inDegree[secondLetter - 'a']++;
                    // System.out.println(secondLetter - 'a');
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<Character>();

        for(int i = 0; i < 26;i++){
            // System.out.println(inDegree[i] + " " + (char)('a' + i));
            if(inDegree[i] == 0){
                queue.add((char)('a' + i));
            }
        }
        
        String ans = "";
        int count = 0;
        while(queue.size() != 0){
            char curr = queue.remove();
            count += 1;
            ans += curr;
            List<Character> list = map.get(curr);
            for(int i = 0; list != null && i < list.size(); i++){
                inDegree[list.get(i) - 'a'] -= 1;
                if(inDegree[list.get(i) - 'a'] == 0)
                queue.add(list.get(i));
            }
        
        }

        if(count != 26)
        System.out.println("Impossible");
        else
        System.out.println(ans);
    }
    

}
