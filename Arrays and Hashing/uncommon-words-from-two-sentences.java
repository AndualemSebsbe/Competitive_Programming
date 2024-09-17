class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap();
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        
        for (String s : str1)
            map.put(s, map.getOrDefault(s, 0) + 1);
        
        for (String s : str2)
            map.put(s, map.getOrDefault(s, 0) + 1);

        List<String> res = new ArrayList();
        for (String key : map.keySet()) {
            int count = map.get(key);
            if (count == 1)
                res.add(key);
        } 

        return res.toArray(new String[0]);
    }
}