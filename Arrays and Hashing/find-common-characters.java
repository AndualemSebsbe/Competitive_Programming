class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        Map<Character, Integer> map = new HashMap();

        for(int i = 0; i < words[0].length(); i++){
            char c = words[0].charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(String word : words){
            int[] count = new int[26];
            for(char c : word.toCharArray()){
                int idx = c - 'a';
                count[idx] += 1;
            }

            for(int i = 0; i < 26; i++){
                char c = (char)('a' + i);
                if(map.containsKey(c)){
                    if(count[i] < map.get(c))
                        map.put(c, count[i]);
                    if(map.get(c) == 0)
                        map.remove(c);
                }
            }
        }

        List<String> res = new ArrayList();
        for(char c : map.keySet()){
            int k = map.get(c);
            while(k-- > 0)
                res.add(c + "");
        }

        return res;
    }
}