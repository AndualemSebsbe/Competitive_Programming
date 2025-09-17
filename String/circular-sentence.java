class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;
        char lastChar = words[0].charAt(words[0].length() - 1);

        for (int i = 1; i < n; i++) {
            int len = words[i].length();
            char firstChar = words[i].charAt(0);
            if (firstChar != lastChar)
                return false;
            
            lastChar = words[i].charAt(len - 1);
        }

        return words[0].charAt(0) == lastChar;
    }
}