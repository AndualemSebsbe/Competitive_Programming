class Solution {
    public int maxRepeating(String sequence, String word) {
        int r = word.length(), len = sequence.length();
        int count = 0, max = 0;
        
        for(int i = 0; i < len; i++){
            if(r <= len && sequence.substring(i, r).equals(word)){
                count = 0;
                int l = i;
                while(r <= len && sequence.substring(l, r).equals(word)){
                    l = r;
                    r += word.length();
                    count += 1;
                }
                
                max = Math.max(max, count);
            }
            r = word.length() + i + 1;
        }
        return max;
    }
}