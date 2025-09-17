class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap();

        for(char c : chars.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int res = 0;
        for(String word : words){
            Map<Character, Integer> strMap = new HashMap();

            for(char c : word.toCharArray())
                strMap.put(c, strMap.getOrDefault(c, 0) + 1);
            
            boolean flag = true;
            for(char key : strMap.keySet()){
                if(!map.containsKey(key) || 
                    map.get(key) < strMap.get(key)){
                        flag = false;
                        break;
                    }
            }

            int n = word.length();
            if(flag)
                res += n;
        }

        return res;
    }
}