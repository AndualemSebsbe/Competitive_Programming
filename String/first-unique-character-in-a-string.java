class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a'] += 1;
        }

        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if(count[idx] == 1)
                return i;
        }

        return -1;
    }
}