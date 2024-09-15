class Solution {

    public int findTheLongestSubstring(String s) {
        int prefixXOR = 0;
        int[] charMap = new int[26];
        charMap['a' - 'a'] = 1;
        charMap['e' - 'a'] = 2;
        charMap['i' - 'a'] = 4;
        charMap['o' - 'a'] = 8;
        charMap['u' - 'a'] = 16;

        int[] map = new int[32];
        for (int i = 0; i < 32; i++) 
            map[i] = -1;

        int longestSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            prefixXOR ^= charMap[s.charAt(i) - 'a'];
            if (map[prefixXOR] == -1 && prefixXOR != 0) 
                map[prefixXOR] = i;

            longestSubstring = Math.max(longestSubstring, i - map[prefixXOR]);
        }

        return longestSubstring;
    }
}