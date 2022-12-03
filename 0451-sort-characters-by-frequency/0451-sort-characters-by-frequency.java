class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        
        List<Integer> list = new ArrayList();
        for(char key : map.keySet())
            if(!list.contains(map.get(key)))
                list.add(map.get(key));
        
        Collections.sort(list);
        Collections.reverse(list);
        
        Map<Integer, List<Character>> listMap = new HashMap();
        for(char key : map.keySet()){
            if(!listMap.containsKey(map.get(key)))
                listMap.put(map.get(key), new ArrayList());
            listMap.get(map.get(key)).add(key);
        }
        
        String res = "";
        for(int i = 0; i < list.size(); i++){
            for(char c : listMap.get(list.get(i)))
                for(int j = 0; j < list.get(i); j++)
                    res += c;
        }
        
        return res;
    }
}