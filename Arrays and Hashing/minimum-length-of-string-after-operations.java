class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        if(n < 3)
            return n;
        
        Map<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.get(c) == 3)
                map.put(c, 1);
        }

        int minLen = 0;
        for(char c : map.keySet())
            minLen += map.get(c);

        return minLen;
    }
}