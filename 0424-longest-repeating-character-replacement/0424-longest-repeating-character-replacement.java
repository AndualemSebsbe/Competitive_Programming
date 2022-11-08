class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap();
        int res = 0, left = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            int maxFreq = findMaxFreq(map);
            
            while((i-left+1) - maxFreq > k){
                c = s.charAt(left);
                map.put(c, map.get(c)-1);
                left += 1;
            }
            
            res = Math.max(res, i-left+1);
        }
        return res;
    }
    
    public int findMaxFreq(Map<Character, Integer> map){
        int maxFreq = 0;
        for(char key : map.keySet())
            if(maxFreq < map.get(key))
                maxFreq = map.get(key);
        
        return maxFreq;
    }
}