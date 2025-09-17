import java.util.ArrayList;
import java.util.List;

class Solution {
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int width = 0, wordsCount = 0;

        for (int idx = 0; idx < words.length; idx++) {
            width += words[idx].length();
            wordsCount++;

            if (idx == words.length - 1 || 
            width + words[idx + 1].length() + wordsCount - 1 >= maxWidth) {
                int allSpaces = maxWidth - width;
                StringBuilder sb = new StringBuilder();

                while (--wordsCount >= 0) {
                    sb.append(words[idx - wordsCount]);
                    int spaces = idx == words.length - 1 ? 1 : 
                    (int) Math.ceil((double) allSpaces / wordsCount);
                    
                    sb.append(" ".repeat(Math.max(0, 
                    Math.min(spaces, allSpaces))));
                    allSpaces -= spaces;
                }

                sb.append(" ".repeat(Math.max(0, allSpaces)));
                res.add(sb.toString());
                wordsCount = 0;
                width = 0;
            }
        }

        return res;
    }
}