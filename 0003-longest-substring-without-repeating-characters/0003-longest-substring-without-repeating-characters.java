class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int left = 0, len = 0;
        
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            
            if(map.containsKey(c))
                if(left <= map.get(c))
                    left = map.get(c)+1;
            
            len = Math.max(len, right - left+1);
            map.put(c, right);
        }
        
        return len;
    }
}