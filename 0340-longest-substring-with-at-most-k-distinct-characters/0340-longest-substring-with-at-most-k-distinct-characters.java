class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap();
        int len = 0;
        
        for(int i = 0, j = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while(map.size() > k){
                char leftChar = s.charAt(j);
                map.put(leftChar, map.get(leftChar) - 1);
                
                if(map.get(leftChar) == 0)
                    map.remove(leftChar);
                j++;
            }
            
            len = Math.max(len, i-j+1);
        }
        
        return len;
    }
}