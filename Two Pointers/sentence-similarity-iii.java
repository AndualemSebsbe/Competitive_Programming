class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        if (words1.length > words2.length) {
            String[] temp = words1;
            words1 = words2;
            words2 = temp;
        }

        int l = 0;
        while (l < words1.length && words1[l].equals(words2[l]))
            l += 1;
        
        int word1R = words1.length - 1;
        int word2R = words2.length - 1;
        while (word1R >= 0 && words1[word1R].equals(words2[word2R])) {
            word1R -= 1;
            word2R -= 1;
        }

        return l > word1R;
    }
}