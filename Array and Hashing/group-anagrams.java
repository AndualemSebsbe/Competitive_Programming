class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(String s : strs){
            char[] count = new char[26];

            for(int i = 0; i < s.length(); i++){
                int idx = s.charAt(i) - 'a';
                count[idx] += 1;
            }

            String str = String.valueOf(count);

            if(!map.containsKey(str))
                map.put(str, new ArrayList());
            map.get(str).add(s);
        }

        List<List<String>> res = new ArrayList();
        for(String key : map.keySet())
            res.add(map.get(key));

        return res;
    }
}