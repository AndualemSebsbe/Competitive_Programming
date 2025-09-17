class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> sMap = new HashMap();
        Map<Character, Integer> tMap = new HashMap();

        for(char c : s.toCharArray())
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        for(char c : t.toCharArray())
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        
        int count = 0;
        for(char c : sMap.keySet()){
            if(tMap.containsKey(c)){
                if(tMap.get(c) < sMap.get(c))
                    count += (sMap.get(c) - tMap.get(c));
            }
            else
                count += sMap.get(c);
        }

        return count;
    }
}